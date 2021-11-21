package com.sbd.sbdproject.model.hardwareRequirement;

import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import com.sbd.sbdproject.model.hardwareRequirement.mapper.HardwareRequirementMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HardwareRequirementService {

  private final HardwareRequirementRepository hardwareRequirementRepository;

  private final HardwareRequirementMapper mapper;

  public List<HardwareRequirementDto> getHardwareRequirements() {

    return hardwareRequirementRepository.findAll().stream()
        .map(mapper::toHardwareRequirementDto)
        .collect(Collectors.toList());
  }

  public HardwareRequirementDto getHardwareRequirementById(int id) {

    return hardwareRequirementRepository.findById(id)
        .map(mapper::toHardwareRequirementDto)
        .orElseThrow(EntityNotFoundException::new);
  }
}
