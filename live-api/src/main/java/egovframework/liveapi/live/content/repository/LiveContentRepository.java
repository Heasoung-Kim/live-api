package egovframework.liveapi.live.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egovframework.liveapi.live.content.domain.LiveContent;

@Repository
public interface LiveContentRepository extends JpaRepository<LiveContent, String> {


}
