package com.sbd.sbdproject.model.gameCreation;

import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("game-creation")
public class GameCreationController {

  private final GameCreationService gameCreationService;

  @GetMapping("al")
  public List<GameCreationDto> getGameCreations() {

    return gameCreationService.getGameCreations();
  }
}
