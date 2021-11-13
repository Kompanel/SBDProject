package com.sbd.sbdproject.model.developer;

import com.sbd.sbdproject.model.gameCreation.GameCreation;
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
@Table(name = "Developerzy")
public class Developer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_developera")
  private Integer developerId;

  @Column(name = "Nazwa_developera")
  private String developerName;

  @Column(name = "Lokalizacja_HQ")
  private String hqLocalization;

  @Column(name = "Ilosc_pracownikow")
  private int employeeNumber;

  @OneToMany(mappedBy = "developer", fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<GameCreation> gameCreations;

}
