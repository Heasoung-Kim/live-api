package egovframework.liveapi.cmm.dto;

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
public class MicStatusDto {
    private int groupId;
    private int micId;
    private String status;
    private String ip;
    private int errorCount;

}
