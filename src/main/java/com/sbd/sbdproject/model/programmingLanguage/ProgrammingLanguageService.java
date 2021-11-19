package com.sbd.sbdproject.model.programmingLanguage;

import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageDto;
import com.sbd.sbdproject.model.programmingLanguage.mapper.ProgrammingLanguageMapper;
import java.util.List;
import java.util.stream.Collectors;
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
}
