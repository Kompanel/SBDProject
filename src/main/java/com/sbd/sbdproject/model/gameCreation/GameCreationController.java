package com.sbd.sbdproject.model.gameCreation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("gameCreation")
public class GameCreationController {

    private final GameCreationService gameCreationService;

    @GetMapping("al")
    public List<GameCreation> getGameCreations() {

        return gameCreationService.getGameCreations();
    }
}
