package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameCreatorDto;
import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.game.dto.RequirementPassageDto;
import com.sbd.sbdproject.model.game.mapper.GameMapper;
import com.sbd.sbdproject.model.gamePlatform.GamePlatformRepository;
import com.sbd.sbdproject.model.graphicsCard.GraphicsCardRepository;
import com.sbd.sbdproject.model.hardwareRequirement.HardwareRequirement;
import com.sbd.sbdproject.model.processor.ProcessorRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

  private final GameRepository gameRepository;

  private final GamePlatformRepository gamePlatformRepository;

  private final ProcessorRepository processorRepository;

  private final GraphicsCardRepository graphicsCardRepository;

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

  public RequirementPassageDto checkRequirements(int gameId, int processorId, int cardId, int ram) {

    Set<HardwareRequirement> list = gameRepository.findById(gameId).get().getHardwareRequirements();

    int graphicsCardBenchmark = graphicsCardRepository.getById(cardId).getBenchmarkValue();
    int processorBenchmark = processorRepository.getById(processorId).getBenchmarkValue();

    RequirementPassageDto requirementPassageDto = RequirementPassageDto.builder().build();

    list.forEach(hr -> {
      if (hr.getRequirementType().equals("Minimalne")) {

        requirementPassageDto.setMinimalGraphicsCard(
            graphicsCardBenchmark >= hr.getGraphicsCard().getBenchmarkValue());
        requirementPassageDto
            .setMinimalProcessor(processorBenchmark >= hr.getProcessor().getBenchmarkValue());
        requirementPassageDto.setMinimalRam(ram >= hr.getRam());
      } else {
        requirementPassageDto.setRecommendedGraphicsCard(
            graphicsCardBenchmark >= hr.getGraphicsCard().getBenchmarkValue());
        requirementPassageDto
            .setRecommendedProcessor(processorBenchmark >= hr.getProcessor().getBenchmarkValue());
        requirementPassageDto.setRecommendedRam(ram >= hr.getRam());
      }
    });

    return requirementPassageDto;
  }

  public List<GameDto> getPcGames() {
    return gameRepository.findAll().stream()
        .filter(game -> game.getGamePlatform()
            .getPlatformName()
            .equals("PC"))
        .map(mapper::gameToGameDto)
        .collect(Collectors.toList());
  }
}
