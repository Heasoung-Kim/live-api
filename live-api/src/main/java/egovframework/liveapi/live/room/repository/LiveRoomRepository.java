package egovframework.liveapi.live.room.repository;

import egovframework.liveapi.live.room.domain.LiveRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveRoomRepository extends JpaRepository<LiveRoom, Integer> {
	
}
