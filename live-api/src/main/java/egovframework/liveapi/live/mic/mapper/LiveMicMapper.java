package egovframework.liveapi.live.mic.mapper;

import java.util.List;

import egovframework.liveapi.live.mic.domain.LiveMic;
import egovframework.liveapi.live.mic.dto.LiveMicDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LiveMicMapper {

	LiveMicMapper INSTANCE = Mappers.getMapper(LiveMicMapper.class);

	LiveMicDto toDto(LiveMic entity);

	LiveMic toEntity(LiveMicDto dto);

    List<LiveMicDto> toDtoList(List<LiveMic> list);

    List<LiveMic> toEntityList(List<LiveMicDto> list);

}
