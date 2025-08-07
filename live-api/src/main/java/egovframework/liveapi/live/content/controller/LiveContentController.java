package egovframework.liveapi.live.content.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import egovframework.liveapi.live.content.dto.LiveContentDto;
import egovframework.liveapi.live.content.service.LiveContentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/content")
@RequiredArgsConstructor
public class LiveContentController {


    private final LiveContentService liveContentService;

    // 실시간 회의 생성
    @PostMapping
    public String createLiveContent(@RequestBody LiveContentDto dto) {
        return liveContentService.createLiveContent(dto);
    }

    // 전체 목록 조회 (필요 시 필터링 추가)
    @GetMapping
    public List<LiveContentDto> getAllLiveContents() {
        return liveContentService.getAllLiveContents();
    }
    
    // ID로 단건 조회
    @GetMapping("/{id}")
    public LiveContentDto getLiveContent(@PathVariable String id) {
        return liveContentService.getLiveContentById(id);
    }
    
    // 실시간 회의 상세 업데이트 
    @PatchMapping
    public void updateLiveContent(@RequestBody LiveContentDto dto) {
        liveContentService.updateLiveContent(dto);
    }    

    // 실시간 회의 상태 업데이트 (예: READY → ACTIVE)
    @PatchMapping("/status/{id}/{status}")
    public void updateStatus(@PathVariable String id, @PathVariable String status) {
        liveContentService.updateStatus(id, status);
    }

    // 실시간 회의 종료 처리 (status: ENDED, liveEndTime 저장 등)
    @PostMapping("/{id}/end")
    public void endLiveContent(@PathVariable String id) {
        liveContentService.endLiveContent(id);
    }

    // 삭제 처리 (soft delete)
    @DeleteMapping("/{id}")
    public void deleteLiveContent(@PathVariable String id) {
        liveContentService.softDelete(id);
    }
	
}
