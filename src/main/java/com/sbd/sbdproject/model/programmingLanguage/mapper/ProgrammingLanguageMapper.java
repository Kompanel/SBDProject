package com.sbd.sbdproject.model.programmingLanguage.mapper;

import com.sbd.sbdproject.model.engine.mapper.EngineMapper;
import com.sbd.sbdproject.model.programmingLanguage.ProgrammingLanguage;
import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = EngineMapper.class)
public interface ProgrammingLanguageMapper {

  @Mappings({
      @Mapping(target = "engines", qualifiedByName = "engineWithoutPlanguage")
  })
  ProgrammingLanguageDto toProgrammingLanguageDto(ProgrammingLanguage programmingLanguage);

  @Named("pLanguageWithoutEngines")
  @Mappings({
      @Mapping(target = "engines", ignore = true)
  })
  ProgrammingLanguageDto toPlanguageDtoWithoutEngines(ProgrammingLanguage programmingLanguage);
}
