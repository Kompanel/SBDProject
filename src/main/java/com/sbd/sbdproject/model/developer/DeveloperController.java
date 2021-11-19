package com.sbd.sbdproject.model.developer;

import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("developer")
@RequiredArgsConstructor
public class DeveloperController {

  private final DeveloperService developerService;

  @GetMapping("al")
  public List<DeveloperDto> getDevelopers() {

    return developerService.getDevelopers();
  }
}
