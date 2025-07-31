package egovframework.liveapi.live.mic.controller;

import java.util.List;

import egovframework.liveapi.live.mic.dto.LiveMicDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.live.mic.service.LiveMicService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/mic")
@RequiredArgsConstructor
public class LiveMicController {

	 private final LiveMicService liveMicService;

	/** 회의장 테스트페이지  */
	@GetMapping("/test")
	public String testRoomMics() {
		System.out.println("✅ Controller test 호출됨");
	    return "success";
	}

	/** 회의장 마이크 목록  */
	@GetMapping("/{roomId}")
    public List<LiveMicDto> getRoomMics(@PathVariable("roomId") Integer roomId) {
        return liveMicService.getRoomMics(roomId);
    }

	/** 회의장 마이크 상세정보  */
	@GetMapping("/{roomId}/{micId}")
    public LiveMicDto getMicById(@PathVariable("roomId") Integer roomId, @PathVariable("micId") int id) {
        return liveMicService.getMicById(roomId, id);
    }

    /** 회의장 마이크 정보 단건삭제 */
    @DeleteMapping("/{id}/mics")
    public Integer removeRoomMicByMicId(@PathVariable Integer id) {
        return liveMicService.removeRoomMicByMicId(id);
    }
}
