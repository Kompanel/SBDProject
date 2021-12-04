package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.hardwareRequirement.HardwareRequirement;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Procesory")
public class Processor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_procesora")
  private Integer processorId;

  @Column(name = "Model_procesora")
  private String processorModel;

  @Column(name = "Producent_procesora")
  private String producer;

  @Column(name = "Litografia")
  private int lithography;

  @Column(name = "Liczba_rdzeni")
  private int cores;

  @Column(name = "Liczba_watkow")
  private int threads;

  @Column(name = "Czestotliwosc_taktowania")
  private int clockFrequency;

  @Column(name = "Rozmiar_cache")
  private int cache;

  @Column(name = "Data_premiery")
  private LocalDate processorPremiere;

  @Column(name = "Zintegrowany_uklad_graficzny")
  private boolean integratedGraphics;

  @Column(name = "Odblokowany_mnoznik")
  private boolean unlockedMultiplier;

  @Column(name = "Pobor_mocy")
  private int powerConsumption;

  @Column(name = "Cena")
  private int processorPrice;

  @Column(name = "Warosc_benchmark")
  private int benchmarkValue;

  @Column(name = "zdjecie")
  private String imageUrl;

  @OneToMany(mappedBy = "processor", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<HardwareRequirement> hardwareRequirements;
}
