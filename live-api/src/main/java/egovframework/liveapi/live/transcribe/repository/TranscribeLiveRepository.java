package egovframework.liveapi.live.transcribe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.live.transcribe.domain.TranscribeLive;

@Repository
public interface TranscribeLiveRepository extends MongoRepository<TranscribeLive, String> {

	TranscribeLive findByContentId(String contentId);
	
	TranscribeLive save(TranscribeLive transcribeResult);
	
	List<TranscribeLive> findAll();

}
