package com.sbd.sbdproject.model.hardwareRequirement.dto;

import lombok.Data;

@Data
public class HardwareRequirementCreatorDto {

  private double discSpace;

  private Integer ram;

  private String requirementType;

  private Integer processorId;

  private Integer graphicsCardId;
}
