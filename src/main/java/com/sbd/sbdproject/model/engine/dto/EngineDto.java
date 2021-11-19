package com.sbd.sbdproject.model.engine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageDto;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class EngineDto {

  private Integer engineId;

  private String engineName;

  private String engineVersion;

  private LocalDate enginePremiere;

  @JsonInclude(Include.NON_NULL)
  private ProgrammingLanguageDto programmingLanguage;

  private List<GameCreationDto> gameCreations;
}
