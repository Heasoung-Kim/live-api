package egovframework.liveapi.live.gateway.dto;

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
public class GatewayRoomDto {

    private Integer groupId;
    private String sessionId;
    private String isStartAvailable;
    private String activeSession;
    private String gatewayStatus;
    private String transmitterStatus;
    private String sttStatus;
    private Integer micCount;

}