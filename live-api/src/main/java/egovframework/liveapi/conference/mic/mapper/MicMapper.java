package egovframework.liveapi.conference.mic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.conference.mic.domain.Mic;
import egovframework.liveapi.conference.mic.dto.MicDto;

@Mapper(componentModel = "spring")
public interface MicMapper {

	MicMapper INSTANCE = Mappers.getMapper(MicMapper.class);

    MicDto toDto(Mic entity);

    Mic toEntity(MicDto dto);

    List<MicDto> toDtoList(List<Mic> list);

    List<Mic> toEntityList(List<MicDto> list);

    // ✅ 업데이트 용: 기존 엔티티에 DTO 값 덮어쓰기 , id는 업데이트 하지 않음
    //@Mapping(target = "id", ignore = true)
    //void updateFromDto(MicDto dto, @MappingTarget Mic mic);
}
