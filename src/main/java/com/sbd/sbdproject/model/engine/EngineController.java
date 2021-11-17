package com.sbd.sbdproject.model.engine;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("engine")
public class EngineController {

    private final EngineService engineService;

    @GetMapping("al")
    public List<Engine> getEngines() {

        return engineService.getEngines();
    }
}
