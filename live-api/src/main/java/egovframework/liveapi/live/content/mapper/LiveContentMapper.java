package egovframework.liveapi.live.content.mapper;

import java.util.List;

import egovframework.liveapi.live.content.domain.LiveContent;
import egovframework.liveapi.live.content.dto.LiveContentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LiveContentMapper {
	LiveContentMapper INSTANCE = Mappers.getMapper(LiveContentMapper.class);

    LiveContentDto toDto(LiveContent entity);

    LiveContent toEntity(LiveContentDto dto);

    List<LiveContentDto> toDtoList(List<LiveContent> list);

    List<LiveContent> toEntityList(List<LiveContentDto> liveContentDtoList);

}
