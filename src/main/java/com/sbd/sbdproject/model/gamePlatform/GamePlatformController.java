package com.sbd.sbdproject.model.gamePlatform;

import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("game-platform")
public class GamePlatformController {

  private final GamePlatformService gamePlatformService;

  @GetMapping("al")
  public List<GamePlatformDto> getGamePlatforms() {
    return gamePlatformService.getGamePlatforms();
  }
}
