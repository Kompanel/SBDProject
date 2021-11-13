package com.sbd.sbdproject.model.gamePlatform;

import com.sbd.sbdproject.model.game.Game;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Platform")
public class GamePlatform {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_platformy")
  private Integer platformId;

  @Column(name = "Nazwa_platformy")
  private String platformName;

  @Column(name = "Producent_platformy")
  private String platformProducer;

  @Column(name = "Premiera_platformy")
  private LocalDate platformPremiere;

  @Column(name = "Cena_platformy")
  private int platformPrice;

  @OneToMany(mappedBy = "gamePlatform",
             cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                 CascadeType.DETACH, CascadeType.REFRESH})
  private List<Game> games;

}
