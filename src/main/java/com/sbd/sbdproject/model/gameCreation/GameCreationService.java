package com.sbd.sbdproject.model.gameCreation;

import com.sbd.sbdproject.model.developer.DeveloperRepository;
import com.sbd.sbdproject.model.engine.EngineRepository;
import com.sbd.sbdproject.model.game.GameRepository;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationCreatorDto;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import com.sbd.sbdproject.model.gameCreation.mapper.GameCreationMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameCreationService {

  private final GameCreationRepository gameCreationRepository;

  private final GameRepository gameRepository;

  private final DeveloperRepository developerRepository;

  private final EngineRepository engineRepository;

  private final GameCreationMapper mapper;

  public List<GameCreationDto> getGameCreations() {

    return gameCreationRepository.findAll().stream()
        .map(mapper::toGameCreationDto)
        .collect(Collectors.toList());
  }

  public GameCreationDto getGameCreationById(int id) {

    return gameCreationRepository.findById(id)
        .map(mapper::toGameCreationDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addGameCreation(GameCreationCreatorDto gameCreationCreatorDto) {

    GameCreation toBeSaved = GameCreation.builder()
        .budget(gameCreationCreatorDto.getBudget())
        .game(gameRepository.findById(gameCreationCreatorDto.getGameId()).orElse(null))
        .developer(
            developerRepository.findById(gameCreationCreatorDto.getDeveloperId()).orElse(null))
        .engine(engineRepository.findById(gameCreationCreatorDto.getEngineId()).orElse(null))
        .build();

    gameCreationRepository.save(toBeSaved);
  }


  public void updateGameCreation(int id, GameCreationCreatorDto gameCreationCreatorDto) {

    GameCreation gameCreation = gameCreationRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    gameCreation.setBudget(gameCreationCreatorDto.getBudget());
    gameCreation.setGame(gameRepository.findById(gameCreationCreatorDto.getGameId()).orElse(null));
    gameCreation.setDeveloper(
        developerRepository.findById(gameCreationCreatorDto.getDeveloperId()).orElse(null));
    gameCreation.setEngine(
        engineRepository.findById(gameCreationCreatorDto.getEngineId()).orElse(null));

    gameCreationRepository.save(gameCreation);
  }

  public void deleteGameCreation(int id) {

    gameCreationRepository.delete(
        gameCreationRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
