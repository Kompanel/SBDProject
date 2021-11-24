package com.sbd.sbdproject.model.gamePlatform.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class GamePlatformCreatorDto {

  private String platformName;

  private String platformProducer;

  private LocalDate platformPremiere;

  private Integer platformPrice;
}
