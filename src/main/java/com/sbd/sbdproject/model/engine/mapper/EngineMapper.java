package com.sbd.sbdproject.model.engine.mapper;

import com.sbd.sbdproject.model.engine.Engine;
import com.sbd.sbdproject.model.engine.dto.EngineDto;
import com.sbd.sbdproject.model.gameCreation.mapper.GameCreationMapper;
import com.sbd.sbdproject.model.programmingLanguage.mapper.ProgrammingLanguageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {
    ProgrammingLanguageMapper.class,
    GameCreationMapper.class
})
public interface EngineMapper {

  @Mappings({
      @Mapping(target = "programmingLanguage", qualifiedByName = "pLanguageWithoutEngines"),
      @Mapping(target = "gameCreations", qualifiedByName = "gameCreationWithoutEngine")
  })
  EngineDto engineToEngineDto(Engine engine);

  @Named("engineWithoutPlanguage")
  @Mappings({
      @Mapping(target = "programmingLanguage", ignore = true)
  })
  EngineDto toEngineDtoWithoutPlanguage(Engine engine);

  @Named("engineWithoutGameCreations")
  @Mappings({
      @Mapping(target = "gameCreations", ignore = true)
  })
  EngineDto toEngineDtoWithoutGameCreations(Engine engine);
}
