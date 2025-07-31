package egovframework.liveapi.conference.mic.service.impl;

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
    public MicDto getMicById(Integer roomId, Integer id) {
        Mic entity = micRepository.findByRoomIdAndId(roomId, id);
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
        Mic mic = micSettingMapper.toEntity(dto);
        micRepository.save(mic);
        return 1;
    }

    @Override
    public Integer removeRoomMicByMicId(Integer id) {
    	micRepository.deleteById(id);
        return 1;
    }


}
