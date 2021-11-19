package com.sbd.sbdproject.model.graphicsCard;

import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import com.sbd.sbdproject.model.graphicsCard.mapper.GraphicsCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GraphicsCardService {

  private final GraphicsCardRepository graphicsRepository;

  private final GraphicsCardMapper mapper;

  public Page<GraphicsCardDto> getAll(int page, int size) {
    return graphicsRepository.findAll(PageRequest.of(page, size)).map(mapper::toGraphicsCardDto);
  }
}
