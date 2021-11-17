package com.sbd.sbdproject.model.engine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final EngineRepository engineRepository;

    public List<Engine> getEngines() {

        return engineRepository.findAll();
    }
}
