package com.sbd.sbdproject.model.programmingLanguage;

import com.sbd.sbdproject.model.engine.Engine;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Jezyki_programowania")
public class ProgrammingLanguage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID_jezyka")
  private Integer languageId;

  @Column(name = "Nazwa_jezyka")
  private String languageName;

  @Column(name = "Tworca_jezyka")
  private String languageCreator;

  @Column(name = "Aktualizacja")
  private String languageVersion;

  @OneToMany(mappedBy = "programmingLanguage",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  private List<Engine> engines;

}
