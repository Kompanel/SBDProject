package com.sbd.sbdproject.model.graphicsCard.mapper;

import com.sbd.sbdproject.model.graphicsCard.GraphicsCard;
import com.sbd.sbdproject.model.graphicsCard.dto.GraphicsCardDto;
import com.sbd.sbdproject.model.hardwareRequirement.mapper.HardwareRequirementMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = HardwareRequirementMapper.class)
public interface GraphicsCardMapper {

  @Mappings({
      @Mapping(target = "hardwareRequirements", qualifiedByName = "hrWithoutGraphics")
  })
  GraphicsCardDto toGraphicsCardDto(GraphicsCard graphicsCard);

  @Named("graphicsWithoutHr")
  @Mappings({
      @Mapping(target = "hardwareRequirements", ignore = true)
  })
  GraphicsCardDto toGraphicsCardDtoWithoutHr(GraphicsCard graphicsCard);
}
