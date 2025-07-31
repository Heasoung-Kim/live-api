package egovframework.liveapi.conference.content.domain;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;


@Entity
@Table(name = "content")
@Getter
public class Content {
	
	@Id
    private String id;
    private String workspaceId;
    private String creatorId;
    private String folderId;
    private String title;
    private String editedTitle;
    private String fileName;
    private String transcribeStatus;
    private String hashTag;
    private int duration;
    private String type; // NOTE, CALL, AUDIO, VIDEO, RECORD, MEETING
    private boolean isMobile;
    private boolean isRecord;
    private boolean isDeleted;
    private boolean isRecycle;
    private boolean isLocked;
    private int saveCount;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String editorId;
    private LocalDateTime meetingEndTime;
    private LocalDateTime meetingStartTime;
}