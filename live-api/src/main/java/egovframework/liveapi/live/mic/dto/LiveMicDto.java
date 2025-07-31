package egovframework.liveapi.live.mic.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
