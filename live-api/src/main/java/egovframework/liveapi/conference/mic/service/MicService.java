package egovframework.liveapi.conference.mic.service;

import java.util.List;

import egovframework.liveapi.conference.mic.dto.MicDto;

public interface MicService {

	List<MicDto> getRoomMics(Integer roomId);
	MicDto getMicById(Integer roomId, Integer id);
	Integer createRoomMic(MicDto dto);
	Integer updateMicId(MicDto dto);
	Integer removeRoomMicByMicId(Integer id);

}
