package com.sbd.sbdproject.model.processor.mapper;

import com.sbd.sbdproject.model.hardwareRequirement.mapper.HardwareRequirementMapper;
import com.sbd.sbdproject.model.processor.Processor;
import com.sbd.sbdproject.model.processor.dto.ProcessorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = HardwareRequirementMapper.class)
public interface ProcessorMapper {

  @Mappings({
      @Mapping(target = "hardwareRequirements", qualifiedByName = "hrWithoutProcessor")
  })
  ProcessorDto processorToProcessorDto(Processor processor);

  @Named("processorWithoutHr")
  @Mappings({
      @Mapping(target = "hardwareRequirements", ignore = true)
  })
  ProcessorDto toProcessorDtoWithoutHR(Processor processor);
}
