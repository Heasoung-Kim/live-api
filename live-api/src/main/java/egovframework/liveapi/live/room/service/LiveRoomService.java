package egovframework.liveapi.live.room.service;

import java.util.List;

import egovframework.liveapi.live.room.dto.LiveRoomDto;

public interface LiveRoomService {

	List<LiveRoomDto> getAllRooms();
	LiveRoomDto getRoomDetails(Integer id);
	Integer createRoom(LiveRoomDto dto);
	Integer removeRoom(Integer id);
	Integer updateRoomById(Integer id, LiveRoomDto dto);

}