package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.game.mapper.GameMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

  private final GameRepository gameRepository;

  private final GameMapper mapper;

  public List<GameDto> allGames() {
    return gameRepository.findAll().stream()
        .map(mapper::gameToGameDto)
        .collect(Collectors.toList());
  }

  public Page<GameDto> getAll(int page, int size) {
    return gameRepository.findAll(PageRequest.of(page, size)).map(mapper::gameToGameDto);
  }
}
