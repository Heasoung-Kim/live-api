package egovframework.liveapi.live.transcribe.domain;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "TranscribeLive")
public class Segment {

	@Transient
	private String sessionId;
    private int speakerId;
    private String segmentId;
    private long startTime;
    private long endTime;
    private long duration;
    private String text;
    @Transient
    private boolean isFinal;

}
