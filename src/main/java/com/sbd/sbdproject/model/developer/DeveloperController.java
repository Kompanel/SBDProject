package com.sbd.sbdproject.model.developer;

import com.sbd.sbdproject.model.developer.dto.DeveloperCreatorDto;
import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
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
@RequestMapping("developers")
@RequiredArgsConstructor
public class DeveloperController {

  private final DeveloperService developerService;

  @GetMapping
  public List<DeveloperDto> getDevelopers() {

    return developerService.getDevelopers();
  }

  @GetMapping("{id}")
  public DeveloperDto getDeveloper(@PathVariable int id) {
    return developerService.getDeveloperById(id);
  }

  @PostMapping
  public void addDeveloper(@RequestBody DeveloperCreatorDto developerCreatorDtoDto) {
    developerService.addDeveloper(developerCreatorDtoDto);
  }

  @PutMapping("{id}")
  public void updateDeveloper(@PathVariable int id, @RequestBody DeveloperCreatorDto developerCreatorDto) {
    developerService.updateDeveloper(id, developerCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteDeveloper(@PathVariable int id) {
    developerService.deleteDeveloper(id);
  }
}
