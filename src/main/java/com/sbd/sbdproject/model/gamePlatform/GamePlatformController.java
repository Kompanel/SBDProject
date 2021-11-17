package com.sbd.sbdproject.model.gamePlatform;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("gamePlatform")
public class GamePlatformController {

    private final GamePlatformService gamePlatformService;

    @GetMapping("al")
    public List<GamePlatform> getGamePlatforms() {
        return gamePlatformService.getGamePlatforms();
    }
}
