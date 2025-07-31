package egovframework.liveapi.live.gateway.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SttStatusDto {
    private String status;
    private int currentConnections;
    private int maxConnections;
    private int activeSessions;
    private int sttSessions;
    private int sttClients;
    private Map<String, Object> groups; // 필요 시 GroupInfoDto로 세분화 가능

}
