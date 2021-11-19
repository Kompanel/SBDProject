package com.sbd.sbdproject.model.developer;

import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
import com.sbd.sbdproject.model.developer.mapper.DeveloperMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeveloperService {

  private final DeveloperRepository developerRepository;

  private final DeveloperMapper mapper;

  public List<DeveloperDto> getDevelopers() {

    return developerRepository.findAll().stream()
        .map(mapper::developerToDeveloperDto)
        .collect(Collectors.toList());
  }
}
