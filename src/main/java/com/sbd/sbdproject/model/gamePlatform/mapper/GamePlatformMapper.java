package com.sbd.sbdproject.model.gamePlatform.mapper;

import com.sbd.sbdproject.model.game.mapper.GameMapper;
import com.sbd.sbdproject.model.gamePlatform.GamePlatform;
import com.sbd.sbdproject.model.gamePlatform.dto.GamePlatformDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = GameMapper.class)
public interface GamePlatformMapper {

  @Mappings({
      @Mapping(target = "games", qualifiedByName = "gamesWithoutGamePlatform")
  })
  GamePlatformDto toGamePlatformDto(GamePlatform gamePlatform);

  @Named("gamePlatformWithoutGames")
  @Mappings({
      @Mapping(target = "games", ignore = true)
  })
  GamePlatformDto toGamePlatformDtoWithoutGames(GamePlatform gamePlatform);
}
