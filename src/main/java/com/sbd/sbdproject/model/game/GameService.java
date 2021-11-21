package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.game.mapper.GameMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

  private final GameRepository gameRepository;

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
}
