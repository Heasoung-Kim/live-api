package egovframework.liveapi.live.transcribe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.transcribe.mapper.AiResultMapper;
import egovframework.liveapi.live.transcribe.repository.AiResultRepository;
import egovframework.liveapi.live.transcribe.service.AiResultService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiResultServiceImpl implements AiResultService {

    private final AiResultRepository aiResultRepository;
    private final AiResultMapper aiResultMapper;

}
