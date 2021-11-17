package com.sbd.sbdproject.model.gameCreation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameCreationService {

    private final GameCreationRepository gameCreationRepository;

    public List<GameCreation> getGameCreations() {
        return gameCreationRepository.findAll();
    }
}
