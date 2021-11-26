package com.sbd.sbdproject.model.game.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequirementPassageDto {

  private boolean minimalGraphicsCard;

  private boolean minimalProcessor;

  private boolean minimalRam;

  private boolean recommendedGraphicsCard;

  private boolean recommendedProcessor;

  private boolean recommendedRam;

}
