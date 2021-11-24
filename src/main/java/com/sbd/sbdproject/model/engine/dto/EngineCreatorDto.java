package com.sbd.sbdproject.model.engine.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EngineCreatorDto {

  private String engineName;

  private String engineVersion;

  private LocalDate enginePremiere;

  private Integer programmingLanguageId;
}
