package egovframework.liveapi.conference.room.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.conference.room.dto.RoomDto;
import egovframework.liveapi.conference.room.service.RoomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/conference/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    /** 모든 회의실 목록 */
    @GetMapping
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    /** 회의장 상세 정보 */
    @GetMapping("/{roomId}")
    public RoomDto getRoomDetails(@PathVariable Integer roomId) {
        return roomService.getRoomDetails(roomId);
    }

    /** 회의장 생성  */
    @PutMapping("/{roomId}")
    public Integer createRoom(@RequestBody RoomDto dto) {
        return roomService.createRoom(dto);
    }

    /** 회의장 삭제  */
    @DeleteMapping("/{roomId}")
    public Integer removeRoom(@PathVariable Integer roomId) {
        return roomService.removeRoom(roomId);
    }

    /** 회의장 정보 수정 */
    @PatchMapping("/{roomId}")
    public Integer updateRoomById(@PathVariable Integer roomId, @RequestBody RoomDto dto) {
        return roomService.updateRoomById(roomId, dto);
    }
}