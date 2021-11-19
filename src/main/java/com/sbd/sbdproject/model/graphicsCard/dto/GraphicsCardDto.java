package com.sbd.sbdproject.model.graphicsCard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class GraphicsCardDto {

  private Integer cardId;

  private String cardModel;

  private String cardProducer;

  private int memory;

  private String memoryType;

  private int powerConsumption;

  private LocalDate premiereDate;

  private int cardPrice;

  private int benchmarkValue;

  @JsonInclude(Include.NON_NULL)
  private List<HardwareRequirementDto> hardwareRequirements;
}
