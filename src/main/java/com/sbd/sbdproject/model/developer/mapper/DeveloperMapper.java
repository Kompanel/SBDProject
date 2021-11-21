package com.sbd.sbdproject.model.developer.mapper;

import com.sbd.sbdproject.model.developer.Developer;
import com.sbd.sbdproject.model.developer.dto.DeveloperDto;
import com.sbd.sbdproject.model.gameCreation.mapper.GameCreationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = GameCreationMapper.class)
public interface DeveloperMapper {

  @Mappings({
      @Mapping(target = "gameCreations", qualifiedByName = "gameCreationWithoutDeveloper")
  })
  DeveloperDto developerToDeveloperDto(Developer developer);

  @Named("developerWithoutGameCreations")
  @Mappings({
      @Mapping(target = "gameCreations", ignore = true)
  })
  DeveloperDto toDeveloperDtoWithoutGameCreations(Developer developer);
}
