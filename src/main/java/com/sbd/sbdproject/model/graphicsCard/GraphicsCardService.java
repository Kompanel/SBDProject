package com.sbd.sbdproject.model.graphicsCard;

import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import com.sbd.sbdproject.model.graphicsCard.mapper.GraphicsCardMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GraphicsCardService {

  private final GraphicsCardRepository graphicsRepository;

  private final GraphicsCardMapper mapper;

  public List<GraphicsCardDto> getGraphicsCards() {

    return graphicsRepository.findAll().stream()
        .map(mapper::toGraphicsCardDto)
        .collect(Collectors.toList());
  }

  public GraphicsCardDto getGraphicsCardById(int id) {

    return graphicsRepository.findById(id)
        .map(mapper::toGraphicsCardDto)
        .orElseThrow(EntityNotFoundException::new);
  }
}
