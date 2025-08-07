package egovframework.liveapi.live.room.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LiveRoomDto {
    private Integer id;
    private Integer roomId;
    private String status;    
    private String errorCode;
    private Boolean connected;
    private String contentId;   
    private String description;
    private Boolean isDeleted;
    private LocalDateTime createAt;
    private LocalDateTime liveStartTime;
    private LocalDateTime liveEndTime;
    private LocalDateTime updateAt;
}