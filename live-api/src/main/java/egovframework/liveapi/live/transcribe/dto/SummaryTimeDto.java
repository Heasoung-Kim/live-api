package egovframework.liveapi.live.transcribe.dto;

import java.util.List;

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
public class SummaryTimeDto {

    private int index;
    private String time;
    private String topic;
    private List<String> summary;

}
