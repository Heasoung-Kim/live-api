package egovframework.liveapi.conference.room.domain;


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
@Table(name = "room")
@Getter
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // varchar(191)

    private Long roomId;
    private String micId;
    private String micName;
    private Integer speakerId;
    private String position;

    @Column(columnDefinition = "DATETIME(3)")
    private LocalDateTime createAt;

    @Column(columnDefinition = "DATETIME(3) ON UPDATE CURRENT_TIMESTAMP(3)")
    private LocalDateTime updateAt;

    private Boolean isDeleted;
    private String description;
}
