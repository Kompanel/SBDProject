package com.sbd.sbdproject.model.engine;

import com.sbd.sbdproject.model.engine.dto.EngineDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("engine")
public class EngineController {

  private final EngineService engineService;

  @GetMapping("al")
  public List<EngineDto> getEngines() {

    return engineService.getEngines();
  }
}
