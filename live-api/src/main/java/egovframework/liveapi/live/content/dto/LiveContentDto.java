package egovframework.liveapi.live.content.dto;

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
public class LiveContentDto {

    private String id;
    private String title;
    private LocalDateTime lastActiveTime;
    private String errorCode;
    private String status; // ENUM('READY', 'ACTIVE', 'ENDED', 'ERROR')
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime meetingStartTime;  // ✅ 예약 시작시간
    private LocalDateTime liveEndTime;
    private String creatorId;
    private String fileName;
    private String contentId;
    private String errorMessage;
    private boolean isDeleted;
    private int liveDuration;
    private LocalDateTime liveStartTime;     // ✅ 실제 시작시간
    private LocalDateTime meetingEndTime;    // ✅ 예약 종료시간

}
