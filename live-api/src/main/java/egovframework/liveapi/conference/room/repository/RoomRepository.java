package egovframework.liveapi.conference.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.conference.room.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
}
