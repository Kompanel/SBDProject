package com.sbd.sbdproject.model.hardwareRequirement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HardwareRequirementService {

    private final HardwareRequirementRepository hardwareRequirementRepository;

    public List<HardwareRequirement> getHardwareRequirements() {
        return hardwareRequirementRepository.findAll();
    }
}
