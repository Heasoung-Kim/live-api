package egovframework.liveapi.conference.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.conference.room.domain.Room;

@Repository
public interface ContentRepository extends JpaRepository<Room, Integer> {


}
