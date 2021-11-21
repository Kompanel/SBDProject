package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorDtoForList;
import com.sbd.sbdproject.model.processor.mapper.ProcessorMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorService {

  private final ProcessorRepository processorRepository;

  private final ProcessorMapper mapper;

  public List<ProcessorDtoForList> getProcessors() {

    return processorRepository.findAll().stream()
        .map(mapper::toListOfProcessors)
        .collect(Collectors.toList());
  }

  public ProcessorDto getProcessorById(int id) {

    return processorRepository.findById(id)
        .map(mapper::processorToProcessorDto)
        .orElseThrow(EntityNotFoundException::new);
  }
}
