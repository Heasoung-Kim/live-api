package egovframework.liveapi.live.mic.service.impl;

import java.util.List;

import egovframework.liveapi.live.mic.domain.LiveMic;
import egovframework.liveapi.live.mic.dto.LiveMicDto;
import org.springframework.stereotype.Service;

import egovframework.liveapi.live.mic.repository.LiveMicRepository;
import egovframework.liveapi.live.mic.mapper.LiveMicMapper;
import egovframework.liveapi.live.mic.service.LiveMicService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LiveMicServiceImpl implements LiveMicService {

    private final LiveMicRepository liveMicRepository;
    private final LiveMicMapper liveMicMapper;

    @Override
    public List<LiveMicDto> getRoomMics(Integer roomId) {
        return liveMicMapper.toDtoList(liveMicRepository.findAllByRoomId(roomId));
    }

    @Override
    public LiveMicDto getMicById(Integer roomId, Integer id) {
    	LiveMic entity = liveMicRepository.findByRoomIdAndId(roomId, id);
        return liveMicMapper.toDto(entity);
    }

	@Override
	public Integer createRoomMic(LiveMicDto dto) {
		LiveMic mic = liveMicMapper.toEntity(dto);
        liveMicRepository.save(mic);
        return 1;
	}


    @Override
    public Integer updateMicId(LiveMicDto dto) {
    	LiveMic mic = liveMicMapper.toEntity(dto);
        liveMicRepository.save(mic);
        return 1;
    }

    @Override
    public Integer removeRoomMicByMicId(Integer id) {
    	liveMicRepository.deleteById(id);
        return 1;
    }


}
