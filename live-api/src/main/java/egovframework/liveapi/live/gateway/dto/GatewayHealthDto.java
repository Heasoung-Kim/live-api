package egovframework.liveapi.live.gateway.dto;

import lombok.Data;

@Data
public class GatewayHealthDto {
    private String status;
    private String timestamp;
    private WorkerInfo workers;
    private String mode;
    private StorageInfo storage;

    @Data
    public static class WorkerInfo {
        private int tcp;
        private int audio;
        private int websocket;
    }

    @Data
    public static class StorageInfo {
        private String type;
        private boolean healthy;
    }
}