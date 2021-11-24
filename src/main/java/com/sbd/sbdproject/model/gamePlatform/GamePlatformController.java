package com.sbd.sbdproject.model.gamePlatform;

import com.sbd.sbdproject.model.game.dto.GameCreatorDto;
import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformCreatorDto;
import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("game-platforms")
public class GamePlatformController {

  private final GamePlatformService gamePlatformService;

  @GetMapping
  public List<GamePlatformDto> getGamePlatforms() {
    return gamePlatformService.getGamePlatforms();
  }

  @GetMapping("{id}")
  public GamePlatformDto getGamePlatform(@PathVariable int id) {

    return gamePlatformService.getGamePlatformById(id);
  }

  @PostMapping
  public void addGamePlatform(@RequestBody GamePlatformCreatorDto gamePlatformCreatorDto) {
    gamePlatformService.addGamePlatform(gamePlatformCreatorDto);
  }

  @PutMapping("{id}")
  public void updateGamePlatform(@PathVariable int id, @RequestBody GamePlatformCreatorDto gamePlatformCreatorDto) {
    gamePlatformService.updateGame(id, gamePlatformCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteGamePlatform(@PathVariable int id) {
    gamePlatformService.deleteGame(id);
  }
}
