package egovframework.liveapi.live.room.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.room.domain.LiveRoom;
import egovframework.liveapi.live.room.dto.LiveRoomDto;
import egovframework.liveapi.live.room.mapper.LiveRoomMapper;
import egovframework.liveapi.live.room.repository.LiveRoomRepository;
import egovframework.liveapi.live.room.service.LiveRoomService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor	
public class LiveRoomServiceImpl implements LiveRoomService{

    private final LiveRoomRepository LiveRoomRepository;
    private final LiveRoomMapper LiveRoomMapper;
	
    @Override
    public List<LiveRoomDto> getAllRooms() {
    	return LiveRoomMapper.toDtoList(LiveRoomRepository.findAll());
    }

    @Override
    public LiveRoomDto getRoomDetails(Integer id) {
    	LiveRoom roomLive = LiveRoomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));
        return LiveRoomMapper.toDto(roomLive);
    }

    /**
    @Override
    public String getRoomStatus(Integer id) {
        Room room = LiveRoomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));
        return room.getStatus();
    }
     */
    
    @Override
    public Integer createRoom(LiveRoomDto dto) {
    	LiveRoom liveRoom = LiveRoomMapper.toEntity(dto);
        LiveRoomRepository.save(liveRoom);
        return 1;
    }



    @Override
    public Integer updateRoomById(Integer id, LiveRoomDto dto) {
        //Room room = LiveRoomRepository.findById(id)
        //        .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));

        // 기타 필요한 필드들...
        //LiveRoomMapper.updateFromDto(dto, room);
        return 1;
    }

	@Override
	public Integer removeRoom(Integer id) {
		return null;
	}
}
