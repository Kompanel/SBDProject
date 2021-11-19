package com.sbd.sbdproject.model.hardwareRequirement;

import com.sbd.sbdproject.model.game.Game;
import com.sbd.sbdproject.model.graphicsCard.GraphicsCard;
import com.sbd.sbdproject.model.processor.Processor;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Wymagania_sprzetowe")
public class HardwareRequirement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_wymagania")
  private Integer id;

  @Column(name = "Przestrzen_dyskowa")
  private double discSpace;

  @Column(name = "ilosc_RAM")
  private int ram;

  @Column(name = "Typ_wymagania")
  private String requirementType;

  @ManyToOne
  @JoinColumn(name = "ID_procesora")
  private Processor processor;

  @ManyToOne
  @JoinColumn(name = "ID_karty")
  private GraphicsCard graphicsCard;

  @ManyToMany
  @JoinTable(
      name = "Wymagania_gry",
      joinColumns = @JoinColumn(name = "ID_wymagania"),
      inverseJoinColumns = @JoinColumn(name = "ID_gry"))
  Set<Game> games;

}
