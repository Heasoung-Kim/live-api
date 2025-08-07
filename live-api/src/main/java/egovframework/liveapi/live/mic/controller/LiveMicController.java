package egovframework.liveapi.live.mic.controller;

import java.util.List;

import egovframework.liveapi.live.mic.dto.LiveMicDto;
import org.springframework.web.bind.annotation.*;

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
	
	/** 회의장 마이크 등록  */
	@PutMapping
    public Integer createRoomMic(@RequestBody LiveMicDto dto) {
        return liveMicService.createRoomMic(dto);
    }

    /** 회의장 마이크 정보 단건삭제 */
    @DeleteMapping("/{id}/mics")
    public Integer removeRoomMicByMicId(@PathVariable Integer id) {
        return liveMicService.removeRoomMicByMicId(id);
    }
}
