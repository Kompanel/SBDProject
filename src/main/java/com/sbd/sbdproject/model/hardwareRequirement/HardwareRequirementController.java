package com.sbd.sbdproject.model.hardwareRequirement;

import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("hardware-requirements")
public class HardwareRequirementController {

  private final HardwareRequirementService hardwareRequirementService;

  @GetMapping
  public List<HardwareRequirementDto> getHardwareRequirements() {
    return hardwareRequirementService.getHardwareRequirements();
  }

  @GetMapping("{id}")
  public HardwareRequirementDto getHardwareRequirement(@PathVariable int id) {

    return hardwareRequirementService.getHardwareRequirementById(id);
  }
}
