package com.sbd.sbdproject.model.programmingLanguage;

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
}
