package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameCreatorDto;
import com.sbd.sbdproject.model.game.dto.GameDto;
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
@RequestMapping("games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GameController {

  private final GameService gameService;

  @GetMapping
  public List<GameDto> getGames() {

    return gameService.getGames();
  }

  @GetMapping("{id}")
  public GameDto getGame(@PathVariable int id) {
    return gameService.getGameById(id);
  }

  @PostMapping
  public void addGame(@RequestBody GameCreatorDto gameCreatorDto) {
    gameService.addGame(gameCreatorDto);
  }

  @PutMapping("{id}")
  public void updateGame(@PathVariable int id, @RequestBody GameCreatorDto gameCreatorDto) {
    gameService.updateGame(id, gameCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteGame(@PathVariable int id) {
    gameService.deleteGame(id);
  }
}
