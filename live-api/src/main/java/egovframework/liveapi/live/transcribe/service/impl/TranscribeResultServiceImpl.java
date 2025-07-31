package egovframework.liveapi.live.transcribe.service.impl;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.transcribe.mapper.TranscribeResultMapper;
import egovframework.liveapi.live.transcribe.repository.TranscribeResultRepository;
import egovframework.liveapi.live.transcribe.service.TranscribeResultService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranscribeResultServiceImpl implements TranscribeResultService {

    private final TranscribeResultRepository transcribeResultRepository;
    private final TranscribeResultMapper transcribeResultMapper;


}
