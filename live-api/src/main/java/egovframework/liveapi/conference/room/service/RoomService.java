package egovframework.liveapi.conference.room.service;

import java.util.List;

import egovframework.liveapi.conference.room.dto.RoomDto;

public interface RoomService {

	List<RoomDto> getAllRooms();
	RoomDto getRoomDetails(Integer id);
	//String getRoomStatus(Integer id);
	Integer softDeleteRoom(Integer id);
	Integer createRoom(RoomDto dto);
	Integer removeRoom(Integer id);
	Integer updateRoomById(RoomDto dto);

}