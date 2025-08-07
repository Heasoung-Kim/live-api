package egovframework.liveapi.live.mic.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livemic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LiveMic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer micId;
    private Integer micIp;
    private Integer roomId;
    private String contentId;
    private String status;
    private Boolean connected;
    private LocalDateTime lastConnectedAt;
    private LocalDateTime lastDataReceivedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}