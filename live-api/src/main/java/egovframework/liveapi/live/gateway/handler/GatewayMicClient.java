package egovframework.liveapi.live.gateway.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.liveapi.cmm.config.ApiPaths;
import egovframework.liveapi.cmm.config.ServerProperties;
import egovframework.liveapi.live.gateway.dto.GatewayHealthDto;
import egovframework.liveapi.live.gateway.dto.GatewayMicDto;
import egovframework.liveapi.live.gateway.dto.SttStatusDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GatewayMicClient {

    private final RestTemplate restTemplate;
    private final ServerProperties serverProps;
    private final ObjectMapper objectMapper;

    /** Gateway로 받은 TCP 통신 health check */
    public GatewayHealthDto getHealthStatus() {
        String url = serverProps.getBaseUrl() + ApiPaths.HEALTH;

        try {
            return restTemplate.getForObject(url, GatewayHealthDto.class);
        } catch (Exception e) {
            throw new RuntimeException("헬스체크 API 호출 실패", e);
        }
    }

    public SttStatusDto getStatus() {
        String url = serverProps.getBaseUrl() + ApiPaths.STATUS;

        try {
            return restTemplate.getForObject(url, SttStatusDto.class);
        } catch (Exception e) {
            throw new RuntimeException("/status 호출 실패", e);
        }
    }
    
    public GatewayMicDto getTransmitterMic(int groupId, int micId) {
        String url = serverProps.getBaseUrl() + ApiPaths.MICROPHONES +"/" + groupId + "/" + micId;

        try {
            String json = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(json);
            JsonNode details = root.get("details");

            GatewayMicDto dto = new GatewayMicDto();
            dto.setMicId(root.get("mic_id").asInt());
            dto.setStatus(details.get("status").asText());
            dto.setBytesReceived(details.get("bytes_received").asLong());

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("마이크 상세 정보 조회 실패", e);
        }
    }

}
