package egovframework.liveapi.live.content.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Table(name = "contentLive")
@Getter
public class LiveContent {
	
	@Id
    private String id;
    private String title;
    private LocalDateTime lastActiveTime;
    private String errorCode;
    private String status; // READY, ACTIVE, ENDED, ERROR
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime meetingStartTime;
    private LocalDateTime liveEndTime;
    private String creatorId;
    private String fileName;
    private String contentId;
    private String errorMessage;
    private String isActive;
    private int liveDuration;
    private LocalDateTime liveStartTime;
}