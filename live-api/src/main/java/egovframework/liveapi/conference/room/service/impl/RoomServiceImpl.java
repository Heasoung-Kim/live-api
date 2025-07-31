package egovframework.liveapi.conference.room.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.liveapi.conference.room.domain.Room;
import egovframework.liveapi.conference.room.dto.RoomDto;
import egovframework.liveapi.conference.room.mapper.RoomMapper;
import egovframework.liveapi.conference.room.repository.RoomRepository;
import egovframework.liveapi.conference.room.service.RoomService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomDto> getAllRooms() {
    	return roomMapper.toDtoList(roomRepository.findAll());
    }

    @Override
    public RoomDto getRoomDetails(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));
        return roomMapper.toDto(room);
    }

    /**
    @Override
    public String getRoomStatus(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));
        return room.getStatus();
    }
     */
    
    @Override
    public Integer createRoom(RoomDto dto) {
        Room room = roomMapper.toEntity(dto);
        roomRepository.save(room);
        return 1;
    }

    @Override
    public Integer removeRoom(Integer id) {
        roomRepository.deleteById(id);
        return 1;
    }

    @Override
    public Integer updateRoomById(Integer id, RoomDto dto) {
        //Room room = roomRepository.findById(id)
        //        .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회의장이 없습니다: " + id));

        // 기타 필요한 필드들...
        //roomMapper.updateFromDto(dto, room);
        return 1;
    }
}
