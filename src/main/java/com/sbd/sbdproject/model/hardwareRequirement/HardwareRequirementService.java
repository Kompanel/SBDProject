package com.sbd.sbdproject.model.hardwareRequirement;

import com.sbd.sbdproject.model.graphicsCard.GraphicsCardRepository;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementCreatorDto;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import com.sbd.sbdproject.model.hardwareRequirement.mapper.HardwareRequirementMapper;
import com.sbd.sbdproject.model.processor.ProcessorRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HardwareRequirementService {

  private final HardwareRequirementRepository hardwareRequirementRepository;

  private final ProcessorRepository processorRepository;

  private final GraphicsCardRepository graphicsCardRepository;

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

  public void addHardwareRequirement(HardwareRequirementCreatorDto hardwareRequirementCreatorDto) {

    HardwareRequirement toBeSaved = HardwareRequirement.builder()
        .ram(hardwareRequirementCreatorDto.getRam())
        .requirementType(hardwareRequirementCreatorDto.getRequirementType())
        .processor(processorRepository.findById(hardwareRequirementCreatorDto.getProcessorId())
            .orElse(null))
        .graphicsCard(
            graphicsCardRepository.findById(hardwareRequirementCreatorDto.getGraphicsCardId())
                .orElse(null))
        .build();

    hardwareRequirementRepository.save(toBeSaved);
  }

  public void updateHardwareRequirement(int id,
      HardwareRequirementCreatorDto hardwareRequirementCreatorDto) {

    HardwareRequirement hardwareRequirement = hardwareRequirementRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    hardwareRequirement.setRam(hardwareRequirementCreatorDto.getRam());
    hardwareRequirement.setRequirementType(hardwareRequirementCreatorDto.getRequirementType());
    hardwareRequirement.setProcessor(
        processorRepository.findById(hardwareRequirementCreatorDto.getProcessorId())
            .orElse(null));
    hardwareRequirement.setGraphicsCard(
        graphicsCardRepository.findById(hardwareRequirementCreatorDto.getGraphicsCardId())
            .orElse(null));

    hardwareRequirementRepository.save(hardwareRequirement);
  }

  public void deleteHardwareRequirement(int id) {

    hardwareRequirementRepository.delete(
        hardwareRequirementRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
