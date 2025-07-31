package egovframework.liveapi.conference.mic.controller;

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
    public MicDto getMicById(@PathVariable("roomId") Integer roomId, @PathVariable("micId") int id) {
        return micService.getMicById(roomId, id);
    }

	/** 회의장 마이크 등록  */
	@PutMapping("/{roomId}/{micId}")
    public Integer createRoomMics(@RequestBody MicDto dto) {
        return micService.createRoomMic(dto);
    }

    /** 회의장 마이크 정보 수정 */
    @PatchMapping("/{roomId}/{micId}")
    public Integer updateRoomMicById(@PathVariable Integer roomId, @PathVariable Integer id, @RequestBody MicDto dto) {
    	
    	MicDto updatedDto = dto.toBuilder()
    		    .roomId(roomId)
    		    .id(id)
    		    .build();
    		
    	return micService.updateMicId(updatedDto);
    }

    /** 회의장 마이크 정보 단건삭제 */
    @DeleteMapping("/{roomId}/{micId}")
    public Integer removeRoomMicByMicId(@PathVariable Integer micId) {
        return micService.removeRoomMicByMicId(micId);
    }
}
