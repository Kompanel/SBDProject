package com.sbd.sbdproject.model.processor;

import com.sbd.sbdproject.model.processor.dto.ProcessorCreatorDto;
import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
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

  public List<ProcessorDto> getProcessors() {

    return processorRepository.findAll().stream()
        .map(mapper::processorToProcessorDto)
        .collect(Collectors.toList());
  }

  public ProcessorDto getProcessorById(int id) {

    return processorRepository.findById(id)
        .map(mapper::processorToProcessorDto)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void addProcessor(ProcessorCreatorDto processorCreatorDto) {

    Processor toBeSaved = Processor.builder()
        .processorModel(processorCreatorDto.getProcessorModel())
        .producer(processorCreatorDto.getProducer())
        .lithography(processorCreatorDto.getLithography())
        .cores(processorCreatorDto.getCores())
        .threads(processorCreatorDto.getThreads())
        .clockFrequency(processorCreatorDto.getClockFrequency())
        .cache(processorCreatorDto.getCache())
        .processorPremiere(processorCreatorDto.getProcessorPremiere())
        .integratedGraphics(processorCreatorDto.isIntegratedGraphics())
        .unlockedMultiplier(processorCreatorDto.isUnlockedMultiplier())
        .powerConsumption(processorCreatorDto.getPowerConsumption())
        .processorPrice(processorCreatorDto.getProcessorPrice())
        .benchmarkValue(processorCreatorDto.getBenchmarkValue())
        .imageUrl(processorCreatorDto.getImageUrl())
        .build();

    processorRepository.save(toBeSaved);
  }

  public void updateProcessor(int id, ProcessorCreatorDto processorCreatorDto) {

    Processor processor = processorRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    processor.setProcessorModel(processorCreatorDto.getProcessorModel());
    processor.setProducer(processorCreatorDto.getProducer());
    processor.setLithography(processorCreatorDto.getLithography());
    processor.setCores(processorCreatorDto.getCores());
    processor.setThreads(processorCreatorDto.getThreads());
    processor.setClockFrequency(processorCreatorDto.getClockFrequency());
    processor.setCache(processorCreatorDto.getCache());
    processor.setProcessorPremiere(processorCreatorDto.getProcessorPremiere());
    processor.setIntegratedGraphics(processorCreatorDto.isIntegratedGraphics());
    processor.setUnlockedMultiplier(processorCreatorDto.isUnlockedMultiplier());
    processor.setPowerConsumption(processorCreatorDto.getPowerConsumption());
    processor.setProcessorPrice(processorCreatorDto.getProcessorPrice());
    processor.setBenchmarkValue(processorCreatorDto.getBenchmarkValue());
    processor.setImageUrl(processorCreatorDto.getImageUrl());

    processorRepository.save(processor);
  }

  public void deleteProcessor(int id) {

    processorRepository.delete(
        processorRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
