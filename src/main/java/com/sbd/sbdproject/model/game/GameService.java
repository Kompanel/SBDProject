package com.sbd.sbdproject.model.game;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

  private final GameRepository gameRepository;

  public Page<Game> getAll(int page, int size) {
    return gameRepository.findAll(PageRequest.of(page, size));
  }
}
