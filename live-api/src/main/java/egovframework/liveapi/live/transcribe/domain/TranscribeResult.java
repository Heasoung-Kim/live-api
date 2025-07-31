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
@Document(collection = "TranscribeResult")
public class TranscribeResult {

    @Id
    private ObjectId _id;
    private ObjectId fileId;
    private String ticket;
    private String status;
    private String clientLanguage;
    private String lastOpenLang;
    private String engine;
    private Date createAt;
    private Date updateAt;
    private List<Segment> segments;
    private List<Speaker> speakerInfo;
    private AiResult aiResult;
    private List<SummaryTime> summaryTime;
    private Date completeAt;
}
