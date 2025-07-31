package egovframework.liveapi.live.gateway.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import egovframework.liveapi.live.gateway.handler.SseStreamClient;
import egovframework.liveapi.live.gateway.handler.SttClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
/** gateway Stream 통신 **/
public class GatewayService {

    private final SseStreamClient sseClient;
    private final SttClient sttApiClient;
    //private final TranscribeLiveRepository transcribeLiveRepository;


    /**  회의 시작 **/
    public String createSession(int groupId) {
    	String sessionId;

    	try {
        	sessionId = sttApiClient.createSession(groupId);
        }catch(Exception e) {
            throw new RuntimeException("세션 시작 실패");
        }

        // MongoDB 저장
    	/**
        TranscribeLive live = TranscribeLive.builder()
       		 .id(new ObjectId())
       		    .sessionId(sessionId)
       		    .groupId(groupId)
       		    .createAt(LocalDateTime.now())
       		    .build();
    	 
        transcribeLiveRepository.save(live);
    	 */
    	
        return sessionId;
    }

    /**  회의 조회 **/
    public SseEmitter connectToSseStream(String sessionId) {
        return sseClient.connectToSseStream(sessionId);
    }

    public SseEmitter streamOnly(String sessionId) {
        return sseClient.streamOnly(sessionId);
    }


    /**  회의 저장
    public void saveSegment(String sessionId, Segment segment) {
    	if (!transcribeLiveRepository.existsBySessionId(sessionId)) {
    		transcribeLiveRepository.save(segment);
    	}
    }
    **/
    /**  회의 종료 **/
    public ResponseEntity<String> stopSessionDisconnect(int groupId, String sessionId) {

    	try {
    		ResponseEntity<String> stop = sttApiClient.stopSession(groupId, sessionId);

            //TranscribeLive live = TranscribeLive.builder()
    			/**	
    			TranscribeLive.builder()
          		 	.sessionId(sessionId)
          		 	.status("DONE")
        		    .completeAt(LocalDateTime.now())
        		    .build();
    			 */
            return stop;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("세션 종료 실패");
        }
    }


}