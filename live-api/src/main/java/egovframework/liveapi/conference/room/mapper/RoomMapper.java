package egovframework.liveapi.conference.room.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.conference.room.domain.Room;
import egovframework.liveapi.conference.room.dto.RoomDto;

@Mapper(componentModel = "spring")
public interface RoomMapper {

	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDto toDto(Room entity);

    Room toEntity(RoomDto dto);

    List<RoomDto> toDtoList(List<Room> list);

    List<Room> toEntityList(List<RoomDto> list);

    // ✅ 업데이트 용: 기존 엔티티에 DTO 값 덮어쓰기 , id는 업데이트 하지 않음
    //@Mapping(target = "id", ignore = true)
    //void updateFromDto(RoomDto dto, @MappingTarget Room room);
}
