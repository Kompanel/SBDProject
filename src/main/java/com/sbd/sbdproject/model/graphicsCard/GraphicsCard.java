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

  @Column(name = "zdjecie")
  private String imageUrl;

  @OneToMany(mappedBy = "graphicsCard", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<HardwareRequirement> hardwareRequirements;


}
