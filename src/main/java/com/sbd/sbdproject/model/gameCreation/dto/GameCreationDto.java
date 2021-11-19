package com.sbd.sbdproject.model.gameCreation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
import com.sbd.sbdproject.model.engine.dto.EngineDto;
import com.sbd.sbdproject.model.game.dto.GameDto;
import lombok.Data;

@Data
public class GameCreationDto {

  private Integer gameCreationId;

  private int budget;

  @JsonInclude(Include.NON_NULL)
  private GameDto game;

  @JsonInclude(Include.NON_NULL)
  private DeveloperDto developer;

  @JsonInclude(Include.NON_NULL)
  private EngineDto engine;
}
