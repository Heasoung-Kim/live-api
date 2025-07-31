package egovframework.liveapi.live.gateway.dto;

import lombok.Data;

@Data
public class GatewayMicDto {
    private int micId;
    private String ipAddress;
    private String status;
    private long packetsReceived;
    private long bytesReceived;
}
