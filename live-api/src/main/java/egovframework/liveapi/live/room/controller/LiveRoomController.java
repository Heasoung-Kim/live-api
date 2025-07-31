package egovframework.liveapi.live.room.controller;


import java.util.List;

import egovframework.liveapi.live.room.dto.LiveRoomDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.live.room.service.LiveRoomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/room")
@RequiredArgsConstructor
public class LiveRoomController {
    private final LiveRoomService liveRoomService;

    /** 모든 회의실 목록 */
    @GetMapping
    public List<LiveRoomDto> getAllRooms() {
        return liveRoomService.getAllRooms();
    }

    /** 회의장 상세 정보 */
    @GetMapping("/{roomId}")
    public LiveRoomDto getRoomDetails(@PathVariable Integer roomId) {
        return liveRoomService.getRoomDetails(roomId);
    }


    /** 회의장 생성  */
    @PutMapping("/{roomId}")
    public Integer createRoom(@RequestBody LiveRoomDto dto) {
        return liveRoomService.createRoom(dto);
    }

    /** 회의장 삭제  */
    @DeleteMapping("/{roomId}")
    public Integer removeRoom(@PathVariable Integer roomId) {
        return liveRoomService.removeRoom(roomId);
    }

    /** 회의장 정보 수정 */
    @PatchMapping("/{roomId}")
    public Integer updateRoomById(@PathVariable Integer roomId, @RequestBody LiveRoomDto dto) {
        return liveRoomService.updateRoomById(roomId, dto);
    }
}