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
public class AiResultDto {
    private List<String> topics;
    private List<String> keywords;
    private List<String> summary;
    private List<String> tasks;
    private List<String> issues;
    private List<String> speakerSummary;

}