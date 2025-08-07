package egovframework.liveapi.conference.mic.domain;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import lombok.*;

@Entity
@Table(name = "mic")
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DynamicUpdate
public class Mic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer micId;

    private Integer roomId;

    @Column(nullable = false)
    private String name;

    private String status; // 예: CONNECTED, DISCONNECTED, MUTE 등

    private String position; // 예: 좌석 위치 등

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}