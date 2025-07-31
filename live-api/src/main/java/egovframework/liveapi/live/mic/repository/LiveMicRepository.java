package egovframework.liveapi.live.mic.repository;

import java.util.List;

import egovframework.liveapi.live.mic.domain.LiveMic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveMicRepository extends JpaRepository<LiveMic, Integer> {

	  List<LiveMic> findAllByRoomId(Integer roomId);
	  LiveMic findByRoomIdAndId(Integer roomId, Integer id);
	  //int createRoomMic(Mic mic);
	  //int save(Mic mic);
	  Integer removeRoomMicById(Integer id);

}
