package egovframework.liveapi.live.gateway.contorller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import egovframework.liveapi.live.gateway.service.SttStreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/live/stream")
public class SttStreamController {

    private final SttStreamService sttStreamService;

    @GetMapping("/test/{groupId}")
    public String test(@PathVariable("groupId") int groupId) {
         //String sessionId = sttStreamService.test(groupId);
         return "SSE 연결 시도 완료 ( groupId: " + groupId + ")";
    }

    @PostMapping("/start/{groupId}")
    public String startSessionAndStream(@PathVariable("groupId") int groupId) {
         String sessionId = sttStreamService.createSession(groupId);
         sttStreamService.connectToSseStream(sessionId);
         return "SSE 연결 시도 완료 (sessionId: "+sessionId+" groupId: " + groupId + ")";
    }

    @GetMapping(value = "/{sessionId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamTranscripts(@PathVariable("sessionId") String sessionId) {
        return sttStreamService.streamOnly(sessionId);
    }

    @PostMapping("/stop/{groupId}/{sessionId}")
    public ResponseEntity<String> stopSessionAndDisconnectSse(@PathVariable("groupId") int groupId, @PathVariable("sessionId") String sessionId) {
        return sttStreamService.stopSessionDisconnect(groupId, sessionId);
    }
}