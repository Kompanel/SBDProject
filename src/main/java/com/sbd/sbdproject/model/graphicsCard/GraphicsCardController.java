package com.sbd.sbdproject.model.graphicsCard;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graphics-cards")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class GraphicsCardController {

  private final GraphicsCardService graphicsService;

  @GetMapping(path = "/all", params = {"page", "size"})
  public ResponseEntity<Page<GraphicsCard>> getAll(@RequestParam("page") int page,
      @RequestParam(name = "size", required = false, defaultValue = "10") int size) {

    return new ResponseEntity<>(graphicsService.getAll(page, size), HttpStatus.OK);
  }


}
