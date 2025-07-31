package egovframework.liveapi.live.room.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.live.room.domain.LiveRoom;
import egovframework.liveapi.live.room.dto.LiveRoomDto;

@Mapper(componentModel = "spring")
public interface LiveRoomMapper {

	LiveRoomMapper INSTANCE = Mappers.getMapper(LiveRoomMapper.class);

    LiveRoomDto toDto(LiveRoom entity);

    LiveRoom toEntity(LiveRoomDto dto);

    List<LiveRoomDto> toDtoList(List<LiveRoom> list);

    List<LiveRoom> toEntityList(List<LiveRoomDto> list);

    // ✅ 업데이트 용: 기존 엔티티에 DTO 값 덮어쓰기 , id는 업데이트 하지 않음
    //@Mapping(target = "id", ignore = true)
    //void updateFromDto(RoomLiveDto dto, @MappingTarget RoomLive RoomLive);
}
