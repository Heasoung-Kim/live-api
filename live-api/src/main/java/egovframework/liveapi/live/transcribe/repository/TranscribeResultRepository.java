package egovframework.liveapi.live.transcribe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.live.transcribe.domain.TranscribeResult;

@Repository
public interface TranscribeResultRepository extends MongoRepository<TranscribeResult, String> {


	TranscribeResult findByFileId();

	TranscribeResult save(TranscribeResult transcribeResult);

	List<TranscribeResult> findAll();

}
