package com.sbd.sbdproject.model.gamePlatform;

import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformCreatorDto;
import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformDto;
import com.sbd.sbdproject.model.gamePlatform.mapper.GamePlatformMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlatformService {

  private final GamePlatformRepository gamePlatformRepository;

  private final GamePlatformMapper mapper;

  public List<GamePlatformDto> getGamePlatforms() {

    return gamePlatformRepository.findAll().stream()
        .map(mapper::toGamePlatformDto)
        .collect(Collectors.toList());
  }

  public GamePlatformDto getGamePlatformById(int id) {

    return gamePlatformRepository.findById(id)
        .map(mapper::toGamePlatformDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addGamePlatform(GamePlatformCreatorDto gamePlatformCreatorDto) {

    GamePlatform toBeSaved = GamePlatform.builder()
        .platformName(gamePlatformCreatorDto.getPlatformName())
        .platformProducer(gamePlatformCreatorDto.getPlatformProducer())
        .platformPremiere(gamePlatformCreatorDto.getPlatformPremiere())
        .platformPrice(gamePlatformCreatorDto.getPlatformPrice())
        .build();

    gamePlatformRepository.save(toBeSaved);
  }

  public void updateGame(int id, GamePlatformCreatorDto gamePlatformCreatorDto) {

    GamePlatform gamePlatform = gamePlatformRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    gamePlatform.setPlatformName(gamePlatformCreatorDto.getPlatformName());
    gamePlatform.setPlatformProducer(gamePlatformCreatorDto.getPlatformProducer());
    gamePlatform.setPlatformPremiere(gamePlatformCreatorDto.getPlatformPremiere());
    gamePlatform.setPlatformPrice(gamePlatformCreatorDto.getPlatformPrice());

    gamePlatformRepository.save(gamePlatform);
  }

  public void deleteGame(int id) {

    gamePlatformRepository.delete(
        gamePlatformRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
