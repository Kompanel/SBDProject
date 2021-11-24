package com.sbd.sbdproject.model.developer;

import com.sbd.sbdproject.model.developer.dto.DeveloperCreatorDto;
import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
import com.sbd.sbdproject.model.developer.mapper.DeveloperMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
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

  public DeveloperDto getDeveloperById(int id) {

    return developerRepository.findById(id)
        .map(mapper::developerToDeveloperDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addDeveloper(DeveloperCreatorDto developerCreatorDtoDto) {

    Developer toBeSaved = Developer.builder()
        .developerName(developerCreatorDtoDto.getDeveloperName())
        .employeeNumber(developerCreatorDtoDto.getEmployeeNumber())
        .hqLocalization(developerCreatorDtoDto.getHqLocalization())
        .build();

    developerRepository.save(toBeSaved);
  }

  public void updateDeveloper(int id, DeveloperCreatorDto developerCreatorDto) {

    Developer developer = developerRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    developer.setDeveloperName(developerCreatorDto.getDeveloperName());
    developer.setEmployeeNumber(developerCreatorDto.getEmployeeNumber());
    developer.setHqLocalization(developerCreatorDto.getHqLocalization());

    developerRepository.save(developer);
  }

  public void deleteDeveloper(int id) {
    developerRepository.delete(developerRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new));
  }
}
