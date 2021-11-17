package com.sbd.sbdproject.model.developer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public List<Developer> getDevelopers() {

        return developerRepository.findAll();
    }
}
