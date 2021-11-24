package com.sbd.sbdproject.model.engine;

import com.sbd.sbdproject.model.engine.dto.EngineCreatorDto;
import com.sbd.sbdproject.model.engine.dto.EngineDto;
import com.sbd.sbdproject.model.engine.mapper.EngineMapper;
import com.sbd.sbdproject.model.programmingLanguage.ProgrammingLanguageRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineService {

  private final EngineRepository engineRepository;

  private final ProgrammingLanguageRepository languageRepository;

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

  public void addEngine(EngineCreatorDto engineCreatorDto) {

    Engine toBeSaved = Engine.builder()
        .engineName(engineCreatorDto.getEngineName())
        .engineVersion(engineCreatorDto.getEngineVersion())
        .enginePremiere(engineCreatorDto.getEnginePremiere())
        .programmingLanguage(
            languageRepository.findById(engineCreatorDto.getProgrammingLanguageId()).orElse(null))
        .build();

    engineRepository.save(toBeSaved);
  }

  public void updateEngine(int id, EngineCreatorDto engineCreatorDto) {

    Engine engine = engineRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    engine.setEngineName(engineCreatorDto.getEngineName());
    engine.setEnginePremiere(engineCreatorDto.getEnginePremiere());
    engine.setEngineVersion(engineCreatorDto.getEngineVersion());
    engine.setProgrammingLanguage(
        languageRepository.findById(engineCreatorDto.getProgrammingLanguageId()).orElse(null));

    engineRepository.save(engine);
  }

  public void deleteEngine(int id) {

    engineRepository.delete(
        engineRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
