package com.sbd.sbdproject.model.programmingLanguage;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("programmingLanguage")
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService programmingLanguageService;

    @GetMapping("al")
    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguageService.getProgrammingLanguages();
    }
}
