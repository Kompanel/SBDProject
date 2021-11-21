package com.sbd.sbdproject.model.graphicsCard;

import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("graphics-cards")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GraphicsCardController {

  private final GraphicsCardService graphicsService;

  @GetMapping
  public List<GraphicsCardDto> getGraphicsCards() {

    return graphicsService.getGraphicsCards();
  }

  @GetMapping("{id}")
  public GraphicsCardDto getGraphicsCard(@PathVariable int id) {

    return graphicsService.getGraphicsCardById(id);
  }
}
