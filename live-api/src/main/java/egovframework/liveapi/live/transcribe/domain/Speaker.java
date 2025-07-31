package egovframework.liveapi.live.transcribe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@Document(collection = "speakerInfo")
public class Speaker {
	
	private String sessionId;
	private int speakerId;
    private String name;
}
