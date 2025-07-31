package egovframework.liveapi.live.mic.service;

import java.util.List;

import egovframework.liveapi.live.mic.dto.LiveMicDto;

public interface LiveMicService {

	List<LiveMicDto> getRoomMics(Integer roomId);
	LiveMicDto getMicById(Integer roomId, Integer id);
	Integer createRoomMic(LiveMicDto dto);
	Integer updateMicId(LiveMicDto dto);
	Integer removeRoomMicByMicId(Integer id);

}
