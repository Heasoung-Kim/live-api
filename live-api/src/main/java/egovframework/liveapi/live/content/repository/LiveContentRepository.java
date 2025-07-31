package egovframework.liveapi.live.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.conference.room.domain.Room;

@Repository
public interface LiveContentRepository extends JpaRepository<Room, Integer> {


}
