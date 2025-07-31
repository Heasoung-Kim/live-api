package egovframework.liveapi.live.room.domain;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "roomlive")
@Getter
@Builder
public class LiveRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer roomId;
    private String name;
    private String status;
    private LocalDateTime liveStartTime;
    private LocalDateTime liveEndTime;
    private String errorCode;
    private Boolean connected;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String contentId;
}
