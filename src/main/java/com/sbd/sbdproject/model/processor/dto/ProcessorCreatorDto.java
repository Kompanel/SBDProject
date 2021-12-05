package com.sbd.sbdproject.model.processor.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProcessorCreatorDto {

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

  private String imageUrl;
}
