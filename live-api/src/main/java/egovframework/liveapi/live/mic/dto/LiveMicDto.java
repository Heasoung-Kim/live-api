package egovframework.liveapi.live.mic.dto;

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
public class LiveMicDto {
    private Integer id;
    private Integer micId;
    private Integer micIp;
    private String contentId;
    private Integer roomId;
    private String status;
    private Boolean connected;
    private LocalDateTime lastConnectedAt;
    private LocalDateTime lastDataReceivedAt;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
