package egovframework.liveapi.live.content.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import egovframework.liveapi.live.content.dto.LiveContentDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
@Table(name = "livecontent")
public class LiveContent {

	@Id
	@Column(name = "id", length = 191)
    private String id;
    private String title;
    private LocalDateTime lastActiveTime;
    private String errorCode;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime meetingStartTime;
    private LocalDateTime liveEndTime;
    private String creatorId;
    private String fileName;
    private Boolean isDeleted;
    private String contentId;
    private String errorMessage;
    private Integer liveDuration;
    private LocalDateTime liveStartTime;
    private LocalDateTime meetingEndTime;

    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
        if (this.createAt == null) {
            this.createAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }

    @Builder
    public LiveContent(String title, LocalDateTime lastActiveTime, String errorCode, String status, LocalDateTime meetingStartTime, LocalDateTime liveEndTime, String creatorId, String fileName, Boolean isDeleted, String contentId, String errorMessage, Integer liveDuration, LocalDateTime liveStartTime, LocalDateTime meetingEndTime) {
        this.title = title;
        this.lastActiveTime = lastActiveTime;
        this.errorCode = errorCode;
        this.status = status;
        this.meetingStartTime = meetingStartTime;
        this.liveEndTime = liveEndTime;
        this.creatorId = creatorId;
        this.fileName = fileName;
        this.isDeleted = isDeleted;
        this.contentId = contentId;
        this.errorMessage = errorMessage;
        this.liveDuration = liveDuration;
        this.liveStartTime = liveStartTime;
        this.meetingEndTime = meetingEndTime;
    }
    
    public void updateFrom(LiveContentDto dto) {
        if (!Objects.equals(this.title, dto.getTitle())) this.title = dto.getTitle();
        if (!Objects.equals(this.status, dto.getStatus())) this.status = dto.getStatus();
        if (!Objects.equals(this.fileName, dto.getFileName())) this.fileName = dto.getFileName();
        if (!Objects.equals(this.liveStartTime, dto.getLiveStartTime())) this.liveStartTime = dto.getLiveStartTime();
        if (!Objects.equals(this.liveEndTime, dto.getLiveEndTime())) this.liveEndTime = dto.getLiveEndTime();
        if (!Objects.equals(this.isDeleted, dto.isDeleted())) this.isDeleted = dto.isDeleted();
        this.updateAt = LocalDateTime.now(); // 이건 항상 갱신
    }
    
    public void markAsDeleted() {
        this.isDeleted = true;
    }
}
