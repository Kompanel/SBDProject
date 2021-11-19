package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.game.dto.GameDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GameController {

  private final GameService gameService;

  @GetMapping(path = "all", params = {"page", "size"})
  public ResponseEntity<Page<GameDto>> getAll(
      @RequestParam("page") int page,
      @RequestParam(name = "size", required = false, defaultValue = "10") int size) {

    return new ResponseEntity<>(gameService.getAll(page, size), HttpStatus.OK);
  }

  @GetMapping("al")
  public List<GameDto> allGames() {
    return gameService.allGames();
  }
}
