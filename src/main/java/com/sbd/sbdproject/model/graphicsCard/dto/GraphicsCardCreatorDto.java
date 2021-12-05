package com.sbd.sbdproject.model.graphicsCard.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class GraphicsCardCreatorDto {

  private String cardModel;

  private String cardProducer;

  private int memory;

  private String memoryType;

  private int powerConsumption;

  private LocalDate premiereDate;

  private int cardPrice;

  private int benchmarkValue;

  private String imageUrl;
}
