package com.sbd.sbdproject.model.gamePlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.game.dto.GameDto;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class GamePlatformDto {

  private Integer platformId;

  private String platformName;

  private String platformProducer;

  private LocalDate platformPremiere;

  private Integer platformPrice;

  @JsonInclude(Include.NON_NULL)
  private List<GameDto> games;
}
