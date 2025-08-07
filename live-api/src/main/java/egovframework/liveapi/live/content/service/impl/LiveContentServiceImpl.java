package egovframework.liveapi.live.content.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.liveapi.live.content.domain.LiveContent;
import egovframework.liveapi.live.content.dto.LiveContentDto;
import egovframework.liveapi.live.content.mapper.LiveContentMapper;
import egovframework.liveapi.live.content.repository.LiveContentRepository;
import egovframework.liveapi.live.content.service.LiveContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiveContentServiceImpl implements LiveContentService {

	private final LiveContentRepository liveContentRepository;
    private final LiveContentMapper liveContentMapper;

    @Override
    public String createLiveContent(LiveContentDto dto) {
        LiveContent entity = liveContentMapper.toEntity(dto);
        LiveContent saved = liveContentRepository.save(entity);
        return saved.getId();
    }

    @Override
    public LiveContentDto getLiveContentById(String id) {
        LiveContent entity = liveContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 존재하지 않습니다."));
        return liveContentMapper.toDto(entity);
    }

    @Override
    public List<LiveContentDto> getAllLiveContents() {
        return liveContentRepository.findAll().stream()
                .map(liveContentMapper::toDto)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public void updateLiveContent(LiveContentDto dto) {
        LiveContent entity = liveContentRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 존재하지 않습니다."));

        entity.updateFrom(dto);
        liveContentRepository.save(entity);
    }
    

    @Override
    @Transactional
    public void updateStatus(String id, String status) {
        LiveContent entity = liveContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 존재하지 않습니다."));

        LiveContent updated = entity.toBuilder()
        		.id(id)
        		.status(status)
                .updateAt(LocalDateTime.now())
                .build();

        liveContentRepository.save(updated);
    }

    @Override
    @Transactional
    public void endLiveContent(String id) {
        LiveContent entity = liveContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 존재하지 않습니다."));

        LiveContent updated = entity.toBuilder()
        		.id(id)
                .status("ENDED")
                .liveEndTime(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        liveContentRepository.save(updated);
    }

    @Override
    @Transactional
    public void softDelete(String id) {
        LiveContent entity = liveContentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 존재하지 않습니다."));
                
        entity.markAsDeleted();
        liveContentRepository.save(entity);
        
    }
}