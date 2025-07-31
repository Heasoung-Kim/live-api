package egovframework.liveapi.live.gateway.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/gateway")
@RequiredArgsConstructor
@Tag(name = "게이트웨이 API", description = "게이트웨이 상태 및 관리 관련 API")
public class GatewayController {

    //private final GatewayApiClient gatewayApiClient;
    //private final TransmitterApiClient transmitterApiClient;
    /**
    @GetMapping("/status")
    @Operation(
        summary = "게이트웨이 상태 조회",
        description = "STT 게이트웨이의 현재 상태를 조회합니다."
    )
    

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "상태 조회 성공",
            content = @Content(schema = @Schema(implementation = SttStatusDto.class))
        ),
        @ApiResponse(
            responseCode = "503",
            description = "게이트웨이 서비스 불가"
        )
    })
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<SttStatusDto> getGatewayStatus() {
    	SttStatusDto status = gatewayApiClient.getStatus();
        return ResponseEntity.ok(status);
    }
    */
    
    /**
    @GetMapping("/mic/{groupId}/{micId}")
    public ResponseEntity<TransmitterMicDto> getTransmitterMic(@PathVariable int groupId, @PathVariable int micId) {
    	TransmitterMicDto transmitterMic = transmitterApiClient.getTransmitterMic(groupId, micId);
        return ResponseEntity.ok(transmitterMic);
    }
    */

}