package com.sbd.sbdproject.model.graphicsCard;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GraphicsCardService {

  private final GraphicsCardRepository graphicsRepository;

  public Page<GraphicsCard> getAll(int page, int size) {
    return graphicsRepository.findAll(PageRequest.of(page, size));
  }
}
