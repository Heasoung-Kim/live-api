package egovframework.liveapi.conference.mic.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.liveapi.conference.mic.domain.Mic;
import egovframework.liveapi.conference.mic.dto.MicDto;
import egovframework.liveapi.conference.mic.mapper.MicMapper;
import egovframework.liveapi.conference.mic.repository.MicRepository;
import egovframework.liveapi.conference.mic.service.MicService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MicServiceImpl implements MicService {

    private final MicRepository micRepository;
    private final MicMapper micSettingMapper;

    @Override
    public List<MicDto> getRoomMics(Integer roomId) {
        return micSettingMapper.toDtoList(micRepository.findAllByRoomId(roomId));
    }

    @Override
    public MicDto getMicById(Integer roomId, Integer micId) {
        Mic entity = micRepository.findByRoomIdAndMicId(roomId, micId);
        return micSettingMapper.toDto(entity);
    }

	@Override
	public Integer createRoomMic(MicDto dto) {
        Mic mic = micSettingMapper.toEntity(dto);
        micRepository.save(mic);
        return 1;
	}


    @Override
    public Integer updateMicId(MicDto dto) {
        Mic entity = micRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Mic not found"));
        
        Mic updated = entity.toBuilder()
                .name(dto.getName())
                .position(dto.getPosition())
                .status(dto.getStatus())
                .updatedAt(LocalDateTime.now())
                .build();
        
        micRepository.save(updated);
        return 1;
    }

    @Override
    public Integer removeRoomMicById(Integer id) {
    	micRepository.deleteById(id);
        return 1;
    }


}
