package com.sbd.sbdproject.model.game.dto;

import com.sbd.sbdproject.model.gamePlatform.GamePlatform;
import java.time.LocalDate;
import lombok.Data;

@Data
public class GameCreatorDto {

  private String gameName;

  private LocalDate gamePremiere;

  private double gamePrice;

  private Integer gamePlatformId;
}
