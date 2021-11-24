package com.sbd.sbdproject.model.engine;

import com.sbd.sbdproject.model.gameCreation.GameCreation;
import com.sbd.sbdproject.model.programmingLanguage.ProgrammingLanguage;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Silniki")
public class Engine {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_silnika")
  private Integer engineId;

  @Column(name = "Nazwa_silnika")
  private String engineName;

  @Column(name = "Wersja_silnika")
  private String engineVersion;

  @Column(name = "Premiera_silnika")
  private LocalDate enginePremiere;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "ID_jezyka")
  private ProgrammingLanguage programmingLanguage;

  @OneToMany(mappedBy = "engine", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<GameCreation> gameCreations;

}
