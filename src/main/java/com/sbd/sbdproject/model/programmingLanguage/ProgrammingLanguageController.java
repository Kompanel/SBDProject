package com.sbd.sbdproject.model.programmingLanguage;

import com.sbd.sbdproject.model.programmingLanguage.dto.ProgrammingLanguageDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("programming-languages")
public class ProgrammingLanguageController {

  private final ProgrammingLanguageService programmingLanguageService;

  @GetMapping
  public List<ProgrammingLanguageDto> getProgrammingLanguages() {
    return programmingLanguageService.getProgrammingLanguages();
  }

  @GetMapping("{id}")
  public ProgrammingLanguageDto getProgrammingLanguage(@PathVariable int id) {

    return programmingLanguageService.getProgrammingLanguageById(id);
  }
}
