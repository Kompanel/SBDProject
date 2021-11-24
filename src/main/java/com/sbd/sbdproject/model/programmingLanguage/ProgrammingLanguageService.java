package com.sbd.sbdproject.model.programmingLanguage;

import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageCreatorDto;
import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageDto;
import com.sbd.sbdproject.model.programmingLanguage.mapper.ProgrammingLanguageMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageService {

  private final ProgrammingLanguageRepository programmingLanguageRepository;

  private final ProgrammingLanguageMapper mapper;

  public List<ProgrammingLanguageDto> getProgrammingLanguages() {
    return programmingLanguageRepository.findAll().stream()
        .map(mapper::toProgrammingLanguageDto)
        .collect(Collectors.toList());
  }

  public ProgrammingLanguageDto getProgrammingLanguageById(int id) {

    return programmingLanguageRepository.findById(id)
        .map(mapper::toProgrammingLanguageDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addProgrammingLanguage(ProgrammingLanguageCreatorDto programmingLanguageCreatorDto) {

    ProgrammingLanguage toBeSaved = ProgrammingLanguage.builder()
        .languageName(programmingLanguageCreatorDto.getLanguageName())
        .languageCreator(programmingLanguageCreatorDto.getLanguageCreator())
        .languageVersion(programmingLanguageCreatorDto.getLanguageVersion())
        .build();

    programmingLanguageRepository.save(toBeSaved);
  }

  public void updateProgrammingLanguage(int id,
      ProgrammingLanguageCreatorDto programmingLanguageCreatorDto) {

    ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    programmingLanguage.setLanguageName(programmingLanguageCreatorDto.getLanguageName());
    programmingLanguage.setLanguageCreator(programmingLanguageCreatorDto.getLanguageCreator());
    programmingLanguage.setLanguageVersion(programmingLanguageCreatorDto.getLanguageVersion());

    programmingLanguageRepository.save(programmingLanguage);
  }

  public void deleteProgrammingLanguage(int id) {

    programmingLanguageRepository.delete(
        programmingLanguageRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
