package com.sbd.sbdproject.model.gameCreation.mapper;

import com.sbd.sbdproject.model.developer.mapper.DeveloperMapper;
import com.sbd.sbdproject.model.engine.mapper.EngineMapper;
import com.sbd.sbdproject.model.game.mapper.GameMapper;
import com.sbd.sbdproject.model.gameCreation.GameCreation;
import com.sbd.sbdproject.model.gameCreation.dto.GameCreationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
    uses = {
        DeveloperMapper.class,
        EngineMapper.class,
        GameMapper.class
    })
public interface GameCreationMapper {

  @Mappings({
      @Mapping(target = "developer", qualifiedByName = "developerWithoutGameCreations"),
      @Mapping(target = "engine", qualifiedByName = "engineWithoutGameCreations"),
      @Mapping(target = "game", qualifiedByName = "gameWithoutGameCreations")
  })
  GameCreationDto toGameCreationDto(GameCreation gameCreation);

  @Named("gameCreationWithoutDeveloper")
  @Mappings({
      @Mapping(target = "developer", ignore = true)
  })
  GameCreationDto toGameCreationDtoWithoutDeveloper(GameCreation gameCreation);

  @Named("gameCreationWithoutEngine")
  @Mappings({
      @Mapping(target = "engine", ignore = true)
  })
  GameCreationDto toGameCreationDtoWithoutEngine(GameCreation gameCreation);

  @Named("gameCreationWithoutGame")
  @Mappings({
      @Mapping(target = "game", ignore = true)
  })
  GameCreationDto toGameCreationDtoWithoutGame(GameCreation gameCreation);
}
