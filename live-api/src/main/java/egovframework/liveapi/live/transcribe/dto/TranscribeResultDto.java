package egovframework.liveapi.live.transcribe.dto;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import egovframework.liveapi.live.transcribe.domain.AiResult;
import egovframework.liveapi.live.transcribe.domain.Segment;
import egovframework.liveapi.live.transcribe.domain.Speaker;
import egovframework.liveapi.live.transcribe.domain.SummaryTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TranscribeResultDto {
	
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
