package com.sbd.sbdproject.model.game.mapper;

import com.sbd.sbdproject.model.game.Game;
import com.sbd.sbdproject.model.game.dto.GameDto;
import com.sbd.sbdproject.model.gameCreation.mapper.GameCreationMapper;
import com.sbd.sbdproject.model.gamePlatform.mapper.GamePlatformMapper;
import com.sbd.sbdproject.model.hardwareRequirement.mapper.HardwareRequirementMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {
    GameCreationMapper.class,
    GamePlatformMapper.class,
    HardwareRequirementMapper.class
})
public interface GameMapper {

  @Mappings({
      @Mapping(target = "gameCreations", qualifiedByName = "gameCreationWithoutGame"),
      @Mapping(target = "gamePlatform", qualifiedByName = "gamePlatformWithoutGames"),
      @Mapping(target = "hardwareRequirements", qualifiedByName = "hrWithoutGames")
  })
  GameDto gameToGameDto(Game game);

  @Named("gameWithoutGameCreations")
  @Mappings({
      @Mapping(target = "gameCreations", ignore = true),
      @Mapping(target = "gamePlatform", qualifiedByName = "gamePlatformWithoutGames"),
      @Mapping(target = "hardwareRequirements", qualifiedByName = "hrWithoutGames")
  })
  GameDto gameToGameDtoWithoutGameCreations(Game game);

  @Named("gamesWithoutGamePlatform")
  @Mappings({
      @Mapping(target = "gameCreations", qualifiedByName = "gameCreationWithoutGame"),
      @Mapping(target = "gamePlatform", ignore = true),
      @Mapping(target = "hardwareRequirements", qualifiedByName = "hrWithoutGames")
  })
  GameDto gameToGameDtoWithoutGamePlatform(Game game);

  @Named("gamesWithoutHr")
  @Mappings({
      @Mapping(target = "gameCreations", qualifiedByName = "gameCreationWithoutGame"),
      @Mapping(target = "gamePlatform", qualifiedByName = "gamePlatformWithoutGames"),
      @Mapping(target = "hardwareRequirements", ignore = true)
  })
  GameDto gameToGameDtoWithoutHr(Game game);
}
