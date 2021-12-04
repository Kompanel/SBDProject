package com.sbd.sbdproject.model.game;

import com.sbd.sbdproject.model.gameCreation.GameCreation;
import com.sbd.sbdproject.model.gamePlatform.GamePlatform;
import com.sbd.sbdproject.model.hardwareRequirement.HardwareRequirement;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Gry")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_gry")
  private Integer id;

  @Column(name = "Nazwa_gry")
  private String gameName;

  @Column(name = "Premiera_gry")
  private LocalDate gamePremiere;

  @Column(name = "Cena_gry")
  private double gamePrice;

  @Column(name = "zdjecie")
  private String imageUrl;

  @ManyToMany
  @JoinTable(
      name = "Wymagania_gry",
      joinColumns = @JoinColumn(name = "ID_gry"),
      inverseJoinColumns = @JoinColumn(name = "ID_wymagania"))
  Set<HardwareRequirement> hardwareRequirements;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "ID_platformy")
  private GamePlatform gamePlatform;

  @OneToMany(mappedBy = "game", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<GameCreation> gameCreations;

}
