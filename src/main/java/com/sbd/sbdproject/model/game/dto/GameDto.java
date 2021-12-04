package com.sbd.sbdproject.model.game.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformDto;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class GameDto {

  private Integer id;

  private String gameName;

  private LocalDate gamePremiere;

  private double gamePrice;

  private String imageUrl;

  @JsonInclude(Include.NON_NULL)
  Set<HardwareRequirementDto> hardwareRequirements;

  @JsonInclude(Include.NON_NULL)
  private GamePlatformDto gamePlatform;

  @JsonInclude(Include.NON_NULL)
  private List<GameCreationDto> gameCreations;
}
