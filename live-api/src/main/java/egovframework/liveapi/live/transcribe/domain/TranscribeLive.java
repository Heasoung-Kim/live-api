package egovframework.liveapi.live.transcribe.domain;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "TranscribeLive")
public class TranscribeLive {

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
