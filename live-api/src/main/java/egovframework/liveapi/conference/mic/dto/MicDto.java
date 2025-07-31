package egovframework.liveapi.conference.mic.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MicDto {

    private Integer id;
    private Integer roomId;
    private Integer micId;
    private String name;
    private String status;
    private String position;

}
