package egovframework.liveapi.conference.mic.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "mic")
@Getter
@Builder
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

}