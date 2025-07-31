package egovframework.liveapi.live.transcribe.dto;

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
public class SegmentDto {
	private String sessionId;
    private int speakerId;
    private String segmentId;
    private long startTime;
    private long endTime;
    private long duration;
    private String text;
    private boolean isFinal;

}