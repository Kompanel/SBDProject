package com.sbd.sbdproject.model.graphicsCard;

import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardCreatorDto;
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

  public void addGraphicsCard(GraphicsCardCreatorDto graphicsCardCreatorDto) {

    GraphicsCard toBeSaved = GraphicsCard.builder()
        .cardModel(graphicsCardCreatorDto.getCardModel())
        .cardProducer(graphicsCardCreatorDto.getCardProducer())
        .memory(graphicsCardCreatorDto.getMemory())
        .memoryType(graphicsCardCreatorDto.getMemoryType())
        .powerConsumption(graphicsCardCreatorDto.getPowerConsumption())
        .premiereDate(graphicsCardCreatorDto.getPremiereDate())
        .cardPrice(graphicsCardCreatorDto.getCardPrice())
        .benchmarkValue(graphicsCardCreatorDto.getBenchmarkValue())
        .build();

    graphicsRepository.save(toBeSaved);
  }

  public void updateGraphicsCard(int id, GraphicsCardCreatorDto graphicsCardCreatorDto) {

    GraphicsCard graphicsCard = graphicsRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    graphicsCard.setCardModel(graphicsCardCreatorDto.getCardModel());
    graphicsCard.setCardProducer(graphicsCardCreatorDto.getCardProducer());
    graphicsCard.setMemory(graphicsCardCreatorDto.getMemory());
    graphicsCard.setMemoryType(graphicsCardCreatorDto.getMemoryType());
    graphicsCard.setPowerConsumption(graphicsCardCreatorDto.getPowerConsumption());
    graphicsCard.setPremiereDate(graphicsCardCreatorDto.getPremiereDate());
    graphicsCard.setCardPrice(graphicsCardCreatorDto.getCardPrice());
    graphicsCard.setBenchmarkValue(graphicsCardCreatorDto.getBenchmarkValue());

    graphicsRepository.save(graphicsCard);
  }

  public void deleteGraphicsCard(int id) {
    graphicsRepository.delete(
        graphicsRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
