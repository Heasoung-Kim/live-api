package egovframework.liveapi.live.room.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LiveRoomDto {
    private String id;
    private Long roomId;
    private Long contentId;
    private String micId;
    private String micName;
    private String micIp;
    private Integer speakerId;
    private Boolean connected;
    private String position;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Boolean isDeleted;
    private String description;
    private String name;
    private String status;
}