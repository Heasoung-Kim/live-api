package egovframework.liveapi.live.room.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "liveroom")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LiveRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer roomId;
    
    private String status;    
    private String errorCode;
    private Boolean connected;
    private String contentId;   
    private String description;
    private Boolean isDeleted;
    private LocalDateTime createAt;
    private LocalDateTime liveStartTime;
    private LocalDateTime liveEndTime;
    private LocalDateTime updateAt;
}
