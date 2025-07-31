package egovframework.liveapi.live.transcribe.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.bson.types.ObjectId;

import egovframework.liveapi.live.transcribe.domain.Segment;
import egovframework.liveapi.live.transcribe.domain.Speaker;
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
public class TranscribeLiveDto {

    @Id
    private ObjectId _id;

    private ObjectId contentId;
    private String status;
    private String lastOpenLang;
    private String groupId;

    private Date createdAt;
    private Date updatedAt;
    private Date completeAt;

    private List<Segment> segments;
    private List<Speaker> speaker;
    
    // Future extensions   
    // private AiResult aiResult;
    // private Summary summary;
    // private List<SummaryTime> summaryTime; 


}
