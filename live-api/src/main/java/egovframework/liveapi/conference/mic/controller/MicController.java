package egovframework.liveapi.conference.mic.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.conference.mic.dto.MicDto;
import egovframework.liveapi.conference.mic.service.MicService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/conference/mic")
@RequiredArgsConstructor
public class MicController {

	 private final MicService micService;

	/** 회의장 테스트페이지  */
	@GetMapping("/test")
	public String testRoomMics() {
	    return "success";
	}

	/** 회의장 마이크 목록  */
	@GetMapping("/{roomId}")
    public List<MicDto> getRoomMics(@PathVariable("roomId") Integer roomId) {
        return micService.getRoomMics(roomId);
    }

	/** 회의장 마이크 상세정보  */
	@GetMapping("/{roomId}/{micId}")
    public MicDto getMicById(@PathVariable("roomId") Integer roomId, @PathVariable("micId") int micId) {
        return micService.getMicById(roomId, micId);
    }

	/** 회의장 마이크 등록  */
	@PutMapping
    public Integer createRoomMic(@RequestBody MicDto dto) {
        return micService.createRoomMic(dto);
    }

    /** 회의장 마이크 정보 수정 */
    @PatchMapping
    public Integer updateRoomMicById(@RequestBody MicDto dto) {
    	
    	MicDto updatedDto = dto.toBuilder()
    			.id(dto.getId())
    		    .name(dto.getName())
    		    .position(dto.getPosition())
    		    .updatedAt(LocalDateTime.now())
    		    .build();
    		
    	return micService.updateMicId(updatedDto);
    }

    /** 회의장 마이크 정보 단건삭제 */
    @DeleteMapping("/{id}")
    public Integer removeRoomMicByMicId(@PathVariable Integer id) {
        return micService.removeRoomMicById(id);
    }
}
