package com.sbd.sbdproject.model.hardwareRequirement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRequirementRepository extends JpaRepository<HardwareRequirement, Integer> {
}
