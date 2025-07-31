package egovframework.liveapi.conference.content.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.conference.content.domain.Content;
import egovframework.liveapi.conference.content.dto.ContentDto;

@Mapper(componentModel = "spring")
public interface ContentMapper {

	ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    ContentDto toDto(Content entity);

    Content toEntity(ContentDto dto);

    List<ContentDto> toDtoList(List<Content> list);

    List<Content> toEntityList(List<ContentDto> list);

    // ✅ 업데이트 용: 기존 엔티티에 DTO 값 덮어쓰기 , id는 업데이트 하지 않음
    //@Mapping(target = "id", ignore = true)
    //void updateFromDto(ContentDto dto, @MappingTarget Content content);
}
