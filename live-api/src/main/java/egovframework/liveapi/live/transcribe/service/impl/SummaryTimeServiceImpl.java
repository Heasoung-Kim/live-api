package egovframework.liveapi.live.transcribe.service.impl;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.transcribe.mapper.SummaryTimeMapper;
import egovframework.liveapi.live.transcribe.repository.SummaryTimeRepository;
import egovframework.liveapi.live.transcribe.service.SummaryTimeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SummaryTimeServiceImpl implements SummaryTimeService {

    private final SummaryTimeRepository summaryTimeRepository;
    private final SummaryTimeMapper summaryTimeMapper;



}
