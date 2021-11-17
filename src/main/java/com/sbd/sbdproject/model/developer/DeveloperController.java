package com.sbd.sbdproject.model.developer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("al")
    public List<Developer> getDevelopers() {

        return developerService.getDevelopers();
    }
}
