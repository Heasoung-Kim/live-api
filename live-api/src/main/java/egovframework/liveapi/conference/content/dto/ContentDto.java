package egovframework.liveapi.conference.content.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentDto {

    private Long id;
    private Long workspaceId;
    private String creatorId;
    private String folderId;
    
    private String title;
    private String editedTitle;
    private String fileName;
    private String transcribeStatus;
    
    private String hashTag;
    private Long duration;
    
    private String type;
    private Boolean isMobile;
    private Boolean isRecord;
    private Boolean isDeleted;
    private Boolean isRecycle;
    private Boolean isLocked;
    private Integer saveCount;
    
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    
    private String editorId;
    private LocalDateTime meetingStartTime;
    private LocalDateTime meetingEndTime;

}
