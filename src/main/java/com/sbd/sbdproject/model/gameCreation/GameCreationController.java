package com.sbd.sbdproject.model.gameCreation;

import com.sbd.sbdproject.model.game.dto.GameCreatorDto;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationCreatorDto;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("game-creations")
public class GameCreationController {

  private final GameCreationService gameCreationService;

  @GetMapping
  public List<GameCreationDto> getGameCreations() {

    return gameCreationService.getGameCreations();
  }

  @GetMapping("{id}")
  public GameCreationDto getGameCreation(@PathVariable int id) {

    return gameCreationService.getGameCreationById(id);
  }

  @PostMapping
  public void addGameCreation(@RequestBody GameCreationCreatorDto gameCreationCreatorDto) {
    gameCreationService.addGameCreation(gameCreationCreatorDto);
  }

  @PutMapping("{id}")
  public void updateGameCreation(@PathVariable int id, @RequestBody GameCreationCreatorDto gameCreationCreatorDto) {
    gameCreationService.updateGameCreation(id, gameCreationCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteGameCreation(@PathVariable int id) {
    gameCreationService.deleteGameCreation(id);
  }
}
