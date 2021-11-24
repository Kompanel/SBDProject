package com.sbd.sbdproject.model.hardwareRequirement;

import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformCreatorDto;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementCreatorDto;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping
  public void addHardwareRequirement(@RequestBody HardwareRequirementCreatorDto hardwareRequirementCreatorDto) {
    hardwareRequirementService.addHardwareRequirement(hardwareRequirementCreatorDto);
  }

  @PutMapping("{id}")
  public void updateGamePlatform(@PathVariable int id, @RequestBody HardwareRequirementCreatorDto hardwareRequirementCreatorDto) {
    hardwareRequirementService.updateHardwareRequirement(id, hardwareRequirementCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteGamePlatform(@PathVariable int id) {
    hardwareRequirementService.deleteHardwareRequirement(id);
  }
}
