package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.game.dto.GameDtoForList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GameController {

  private final GameService gameService;

  @GetMapping
  public List<GameDtoForList> getGames() {

    return gameService.getGames();
  }

  @GetMapping("{id}")
  public GameDto getGame(@PathVariable int id) {
    return gameService.getGameById(id);
  }
}
