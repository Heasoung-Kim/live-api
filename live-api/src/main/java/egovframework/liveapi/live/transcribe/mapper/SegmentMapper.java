package egovframework.liveapi.live.transcribe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.live.transcribe.domain.Segment;
import egovframework.liveapi.live.transcribe.dto.SegmentDto;

@Mapper(componentModel = "spring")
public interface SegmentMapper {
    SegmentMapper INSTANCE = Mappers.getMapper(SegmentMapper.class);

    SegmentDto toDto(Segment entity);

    Segment toEntity(SegmentDto dto);
}