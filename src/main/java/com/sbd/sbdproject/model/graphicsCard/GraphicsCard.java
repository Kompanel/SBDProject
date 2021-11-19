package com.sbd.sbdproject.model.graphicsCard;

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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Karty_graficzne")
public class GraphicsCard {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_karty")
  private Integer cardId;

  @Column(name = "Model_karty")
  private String cardModel;

  @Column(name = "Producent_karty")
  private String cardProducer;

  @Column(name = "Ilosc_pamieci")
  private int memory;

  @Column(name = "Rodzaj_pamieci")
  private String memoryType;

  @Column(name = "Pobor_mocy")
  private int powerConsumption;

  @Column(name = "Data_premiery")
  private LocalDate premiereDate;

  @Column(name = "Cena")
  private int cardPrice;

  @Column(name = "Wartosc_benchmark")
  private int benchmarkValue;

  @OneToMany(mappedBy = "graphicsCard", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<HardwareRequirement> hardwareRequirements;


}
