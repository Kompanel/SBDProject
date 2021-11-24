package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameCreatorDto;
import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.game.mapper.GameMapper;
import com.sbd.sbdproject.model.gamePlatform.GamePlatformRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

  private final GameRepository gameRepository;

  private final GamePlatformRepository gamePlatformRepository;

  private final GameMapper mapper;

  public List<GameDto> getGames() {

    return gameRepository.findAll().stream()
        .map(mapper::gameToGameDto)
        .collect(Collectors.toList());
  }

  public GameDto getGameById(int id) {

    return gameRepository.findById(id)
        .map(mapper::gameToGameDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addGame(GameCreatorDto gameCreatorDto) {

    Game toBeSaved = Game.builder()
        .gameName(gameCreatorDto.getGameName())
        .gamePremiere(gameCreatorDto.getGamePremiere())
        .gamePrice(gameCreatorDto.getGamePrice())
        .gamePlatform(
            gamePlatformRepository.findById(gameCreatorDto.getGamePlatformId()).orElse(null))
        .build();

    gameRepository.save(toBeSaved);
  }

  public void updateGame(int id, GameCreatorDto gameCreatorDto) {

    Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    game.setGameName(gameCreatorDto.getGameName());
    game.setGamePremiere(gameCreatorDto.getGamePremiere());
    game.setGamePrice(gameCreatorDto.getGamePrice());
    game.setGamePlatform(
        gamePlatformRepository.findById(gameCreatorDto.getGamePlatformId()).orElse(null));

    gameRepository.save(game);
  }


  public void deleteGame(int id) {

    gameRepository.delete(gameRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
