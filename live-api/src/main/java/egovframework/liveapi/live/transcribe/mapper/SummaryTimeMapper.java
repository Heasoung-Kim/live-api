package egovframework.liveapi.live.transcribe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.live.transcribe.domain.Speaker;
import egovframework.liveapi.live.transcribe.dto.SpeakerDto;

@Mapper(componentModel = "spring")
public interface SummaryTimeMapper {
    SummaryTimeMapper INSTANCE = Mappers.getMapper(SummaryTimeMapper.class);

    SpeakerDto toDto(Speaker entity);
    Speaker toEntity(SpeakerDto dto);
}
