package egovframework.liveapi.live.transcribe.service.impl;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.transcribe.mapper.SpeakerMapper;
import egovframework.liveapi.live.transcribe.repository.SpeakerRepository;
import egovframework.liveapi.live.transcribe.service.SpeakerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpeakerServiceImpl implements SpeakerService {

    private final SpeakerRepository speakerRepository;
    private final SpeakerMapper speakerMapper;


}
