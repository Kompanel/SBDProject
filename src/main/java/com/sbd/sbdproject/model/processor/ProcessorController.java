package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorDtoForList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("processors")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProcessorController {

  private final ProcessorService processorService;

  @GetMapping
  public List<ProcessorDtoForList> getProcessors() {

    return processorService.getProcessors();
  }

  @GetMapping("{id}")
  public ProcessorDto getProcessor(@PathVariable int id) {

    return processorService.getProcessorById(id);
  }
}
