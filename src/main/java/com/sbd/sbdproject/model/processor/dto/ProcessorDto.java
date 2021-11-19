package com.sbd.sbdproject.model.processor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class ProcessorDto {

  private Integer processorId;

  private String processorModel;

  private String producer;

  private int lithography;

  private int cores;

  private int threads;

  private int clockFrequency;

  private int cache;

  private LocalDate processorPremiere;

  private boolean integratedGraphics;

  private boolean unlockedMultiplier;

  private int powerConsumption;

  private int processorPrice;

  private int benchmarkValue;

  @JsonInclude(Include.NON_NULL)
  private List<HardwareRequirementDto> hardwareRequirements;
}
