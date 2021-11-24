package com.sbd.sbdproject.model.graphicsCard;

import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformCreatorDto;
import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardCreatorDto;
import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping
  public void addGraphicsCard(@RequestBody GraphicsCardCreatorDto graphicsCardCreatorDto) {
    graphicsService.addGraphicsCard(graphicsCardCreatorDto);
  }

  @PutMapping("{id}")
  public void updateGraphicsCard(@PathVariable int id, @RequestBody GraphicsCardCreatorDto graphicsCardCreatorDto) {
    graphicsService.updateGraphicsCard(id, graphicsCardCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteGraphicsCard(@PathVariable int id) {
    graphicsService.deleteGraphicsCard(id);
  }
}
