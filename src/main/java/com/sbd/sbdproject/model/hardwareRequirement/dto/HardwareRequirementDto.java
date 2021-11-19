package com.sbd.sbdproject.model.hardwareRequirement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import java.util.Set;
import lombok.Data;

@Data
public class HardwareRequirementDto {

  private Integer id;

  private double discSpace;

  private int ram;

  private String requirementType;

  @JsonInclude(Include.NON_NULL)
  private ProcessorDto processor;

  @JsonInclude(Include.NON_NULL)
  private GraphicsCardDto graphicsCard;

  @JsonInclude(Include.NON_NULL)
  Set<GameDto> games;
}
