package egovframework.liveapi.conference.mic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.conference.mic.domain.Mic;

@Repository
public interface MicRepository extends JpaRepository<Mic, Integer> {

	  List<Mic> findAllByRoomId(Integer roomId);
	  Mic findByRoomIdAndMicId(Integer roomId, Integer micId);
	  Integer removeRoomMicById(Integer id);
	  void deleteById(Integer id);

}
