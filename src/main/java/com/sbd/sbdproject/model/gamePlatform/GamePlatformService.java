package com.sbd.sbdproject.model.gamePlatform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamePlatformService {

    private final GamePlatformRepository gamePlatformRepository;

    public List<GamePlatform> getGamePlatforms() {
        return gamePlatformRepository.findAll();
    }
}
