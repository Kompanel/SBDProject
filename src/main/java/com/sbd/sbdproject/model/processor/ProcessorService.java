package com.sbd.sbdproject.model.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorService {

  private final ProcessorRepository processorRepository;

  public Page<Processor> getAll(int page, int size) {
    return processorRepository.findAll(PageRequest.of(page, size));
  }

  public List<Processor> getProcessors() {
    return processorRepository.findAll();
  }
}
