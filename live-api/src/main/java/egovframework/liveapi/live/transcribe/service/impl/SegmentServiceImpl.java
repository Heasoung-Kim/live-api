package egovframework.liveapi.live.transcribe.service.impl;

import org.springframework.stereotype.Service;

import egovframework.liveapi.live.transcribe.mapper.SegmentMapper;
import egovframework.liveapi.live.transcribe.repository.SegmentRepository;
import egovframework.liveapi.live.transcribe.service.SegmentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SegmentServiceImpl implements SegmentService {

    private final SegmentRepository SegmentRepository;
    private final SegmentMapper SegmentMapper;


}
