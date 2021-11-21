package com.sbd.sbdproject.model.engine;

import com.sbd.sbdproject.model.engine.dto.EngineDto;
import com.sbd.sbdproject.model.engine.mapper.EngineMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineService {

  private final EngineRepository engineRepository;

  private final EngineMapper mapper;

  public List<EngineDto> getEngines() {

    return engineRepository.findAll().stream()
        .map(mapper::engineToEngineDto)
        .collect(Collectors.toList());
  }

  public EngineDto getEngineById(int id) {

    return engineRepository.findById(id)
        .map(mapper::engineToEngineDto)
        .orElseThrow(EntityNotFoundException::new);
  }
}
