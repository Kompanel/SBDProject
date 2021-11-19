package com.sbd.sbdproject.model.gameCreation;

import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import com.sbd.sbdproject.model.gameCreation.mapper.GameCreationMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameCreationService {

  private final GameCreationRepository gameCreationRepository;

  private final GameCreationMapper mapper;

  public List<GameCreationDto> getGameCreations() {
    return gameCreationRepository.findAll().stream()
        .map(mapper::toGameCreationDto)
        .collect(Collectors.toList());
  }
}
