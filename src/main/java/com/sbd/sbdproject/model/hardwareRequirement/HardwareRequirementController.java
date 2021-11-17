package com.sbd.sbdproject.model.hardwareRequirement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hardwareRequirement")
public class HardwareRequirementController {

    private final HardwareRequirementService hardwareRequirementService;

    @GetMapping("al")
    public List<HardwareRequirement> getHardwareRequirements() {
        return hardwareRequirementService.getHardwareRequirements();
    }
}
