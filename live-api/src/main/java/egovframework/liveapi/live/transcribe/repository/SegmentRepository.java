package egovframework.liveapi.live.transcribe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.live.transcribe.domain.Segment;

@Repository
public interface  SegmentRepository extends MongoRepository<Segment, String> {
	boolean existsBySessionId(String sessionId);
	//Integer saveSegments(List<SegmentDto> segmentBuffer);

}
