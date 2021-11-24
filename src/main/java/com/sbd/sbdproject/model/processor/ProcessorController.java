package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardCreatorDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorCreatorDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("processors")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProcessorController {

  private final ProcessorService processorService;

  @GetMapping
  public List<ProcessorDto> getProcessors() {

    return processorService.getProcessors();
  }

  @GetMapping("{id}")
  public ProcessorDto getProcessor(@PathVariable int id) {

    return processorService.getProcessorById(id);
  }

  @PostMapping
  public void addProcessor(@RequestBody ProcessorCreatorDto processorCreatorDto) {
    processorService.addProcessor(processorCreatorDto);
  }

  @PutMapping("{id}")
  public void updateProcessor(@PathVariable int id, @RequestBody ProcessorCreatorDto processorCreatorDto) {
    processorService.updateProcessor(id, processorCreatorDto);
  }

  @DeleteMapping("{id}")
  public void deleteProcessor(@PathVariable int id) {
    processorService.deleteProcessor(id);
  }
}
