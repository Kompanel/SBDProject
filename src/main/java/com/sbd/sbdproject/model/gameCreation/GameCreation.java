package com.sbd.sbdproject.model.gameCreation;

import com.sbd.sbdproject.model.developer.Developer;
import com.sbd.sbdproject.model.engine.Engine;
import com.sbd.sbdproject.model.game.Game;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Tworzenia_gier")
public class GameCreation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_tworzenia_gry")
  private Integer gameCreationId;

  @Column(name = "Budzet")
  private int budget;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "ID_gry")
  private Game game;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "ID_developera")
  private Developer developer;


  @ManyToOne(fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "ID_silnika")
  private Engine engine;
}
