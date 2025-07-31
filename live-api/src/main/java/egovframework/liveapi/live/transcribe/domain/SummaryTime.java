package egovframework.liveapi.live.transcribe.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "summaryTime")
public class SummaryTime {

    private int index;
    private String time;
    private String topic;
    private List<String> summary;

}
