package com.sbd.sbdproject.model.developer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import java.util.List;
import lombok.Data;

@Data
public class DeveloperDto {

  private Integer developerId;

  private String developerName;

  private String hqLocalization;

  private int employeeNumber;

  @JsonInclude(Include.NON_NULL)
  private List<GameCreationDto> gameCreations;
}
