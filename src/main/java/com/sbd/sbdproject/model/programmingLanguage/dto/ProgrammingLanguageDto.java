package com.sbd.sbdproject.model.programmingLanguage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.engine.dto.EngineDto;
import java.util.List;
import lombok.Data;

@Data
public class ProgrammingLanguageDto {

  private Integer languageId;

  private String languageName;

  private String languageCreator;

  private String languageVersion;

  @JsonInclude(Include.NON_NULL)
  private List<EngineDto> engines;
}
