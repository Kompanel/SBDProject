package com.sbd.sbdproject.model.hardwareRequirement.mapper;

import com.sbd.sbdproject.model.game.mapper.GameMapper;
import com.sbd.sbdproject.model.graphicsCard.mapper.GraphicsCardMapper;
import com.sbd.sbdproject.model.hardwareRequirement.HardwareRequirement;
import com.sbd.sbdproject.model.hardwareRequirement.dto.HardwareRequirementDto;
import com.sbd.sbdproject.model.processor.mapper.ProcessorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {
    ProcessorMapper.class,
    GraphicsCardMapper.class,
    GameMapper.class
})
public interface HardwareRequirementMapper {

  @Mappings({
      @Mapping(target = "processor", qualifiedByName = "processorWithoutHr"),
      @Mapping(target = "graphicsCard", qualifiedByName = "graphicsWithoutHr"),
      @Mapping(target = "games", qualifiedByName = "gamesWithoutHr")
  })
  HardwareRequirementDto toHardwareRequirementDto(HardwareRequirement hardwareRequirement);

  @Named("hrWithoutProcessor")
  @Mappings({
      @Mapping(target = "processor", ignore = true),
      @Mapping(target = "graphicsCard", qualifiedByName = "graphicsWithoutHr"),
      @Mapping(target = "games", qualifiedByName = "gamesWithoutHr")
  })
  HardwareRequirementDto toHrWithoutProcessor(HardwareRequirement hardwareRequirement);

  @Named("hrWithoutGraphics")
  @Mappings({
      @Mapping(target = "processor", qualifiedByName = "processorWithoutHr"),
      @Mapping(target = "graphicsCard", ignore = true),
      @Mapping(target = "games", qualifiedByName = "gamesWithoutHr")
  })
  HardwareRequirementDto toHrWithoutGraphics(HardwareRequirement hardwareRequirement);

  @Named("hrWithoutGames")
  @Mappings({
      @Mapping(target = "processor", qualifiedByName = "processorWithoutHr"),
      @Mapping(target = "graphicsCard", qualifiedByName = "graphicsWithoutHr"),
      @Mapping(target = "games", ignore = true)
  })
  HardwareRequirementDto toHrWithoutGames(HardwareRequirement hardwareRequirement);
}
