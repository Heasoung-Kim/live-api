package egovframework.liveapi.live.gateway.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import egovframework.liveapi.cmm.config.ApiPaths;
import egovframework.liveapi.cmm.config.ServerProperties;
import egovframework.liveapi.live.gateway.dto.GatewayHealthDto;
import egovframework.liveapi.live.gateway.dto.SttStatusDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SessionApiClient {

    private final RestTemplate restTemplate;
    private final ServerProperties serverProps;

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

}
