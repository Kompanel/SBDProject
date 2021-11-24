package com.sbd.sbdproject.model.engine;

import com.sbd.sbdproject.model.engine.dto.EngineCreatorDto;
import com.sbd.sbdproject.model.engine.dto.EngineDto;
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
@RequestMapping("engines")
public class EngineController {

  private final EngineService engineService;

  @GetMapping
  public List<EngineDto> getEngines() {

    return engineService.getEngines();
  }

  @GetMapping("{id}")
  public EngineDto getEngine(@PathVariable int id) {
    return engineService.getEngineById(id);
  }

  @PostMapping
  public void addEngine(@RequestBody EngineCreatorDto engineCreatorDto) {
    engineService.addEngine(engineCreatorDto);
  }

  @PutMapping("{id}")
  public void updateEngine(@PathVariable int id, @RequestBody EngineCreatorDto engineCreatorDto) {
    engineService.updateEngine(id, engineCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteEngine(@PathVariable int id) {
    engineService.deleteEngine(id);
  }
}
