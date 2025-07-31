package egovframework.liveapi.live.gateway.contorller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.live.gateway.dto.SttStatusDto;
import egovframework.liveapi.live.gateway.handler.SttClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/stt")
@RequiredArgsConstructor
public class SttController {

    private final SttClient sttApiClient;

    @GetMapping("/status")
    public ResponseEntity<SttStatusDto> getSttStatus() {
    	SttStatusDto status = sttApiClient.getStatus();
        return ResponseEntity.ok(status);
    }
}