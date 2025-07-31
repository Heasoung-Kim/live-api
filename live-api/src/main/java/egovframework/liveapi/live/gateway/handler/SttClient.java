package egovframework.liveapi.live.gateway.handler;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import egovframework.liveapi.cmm.config.ApiPaths;
import egovframework.liveapi.cmm.config.ServerProperties;
import egovframework.liveapi.live.gateway.dto.SttStatusDto;
import lombok.RequiredArgsConstructor;
import reactor.core.Disposable;

@Component
@RequiredArgsConstructor
public class SttClient {

    private final RestTemplate restTemplate;
    private final ServerProperties serverProps;
    private final Map<String, Disposable> activeStreams = new ConcurrentHashMap<>();

    public String createSession(int groupId) {
    	String url = serverProps.getBaseUrl() + ApiPaths.SESSION_START.replace("{groupId}", String.valueOf(groupId));
    	try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
            return extractSessionId(response.getBody());
        } catch (Exception e) {
        	//log.error("Failed to start session", e);
            throw new RuntimeException("세션 시작 실패");
        }
    }

    private String extractSessionId(String json) {
        // JSON 파서 대신 간단히 처리 (예시)
        int start = json.indexOf("\"session_id\":") + 14;
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }


    public SttStatusDto getStatus() {
        String url = serverProps.getBaseUrl() + ApiPaths.STATUS;

        try {
            return restTemplate.getForObject(url, SttStatusDto.class);
        } catch (Exception e) {
            throw new RuntimeException("/status 호출 실패", e);
        }
    }

    public ResponseEntity<String> stopSession(int groupId, String sessionId) {
        String url = serverProps.getBaseUrl() + ApiPaths.SESSION_STOP.replace("{groupId}", String.valueOf(groupId));
        try {
        	return restTemplate.postForEntity(url, null, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            throw ex;
        }
    }

    public void disconnectFromSseStream(String sessionId) {
        Disposable subscription = activeStreams.remove(sessionId);
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
            System.out.println("✅ SSE 연결 종료 완료: " + sessionId);
        } else {
            System.out.println("⚠️ SSE 연결 없음 또는 이미 종료됨: " + sessionId);
        }
    }

}
