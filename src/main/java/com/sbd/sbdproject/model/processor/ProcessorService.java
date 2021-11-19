package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import com.sbd.sbdproject.model.processor.mapper.ProcessorMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorService {

  private final ProcessorRepository processorRepository;

  private final ProcessorMapper mapper;

  public Page<ProcessorDto> getAll(int page, int size) {
    return processorRepository.findAll(PageRequest.of(page, size))
        .map(mapper::processorToProcessorDto);
  }

  public List<ProcessorDto> getProcessors() {
    return processorRepository.findAll().stream()
        .map(mapper::processorToProcessorDto)
        .collect(Collectors.toList());
  }

}
