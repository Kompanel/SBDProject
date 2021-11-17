package com.sbd.sbdproject.model.programmingLanguage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }
}
