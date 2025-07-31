package egovframework.liveapi.live.transcribe.domain;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "aiResult")
public class AiResult {

    @Id
    private String sessionId;
    private List<String> topics;
    private List<String> keywords;
    private List<String> summary;
    private List<String> tasks;
    private List<String> issues;
    private List<String> speakerSummary;

}
