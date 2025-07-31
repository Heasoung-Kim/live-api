package egovframework.liveapi.live.gateway.handler;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import egovframework.liveapi.cmm.config.ApiPaths;
import egovframework.liveapi.cmm.config.ServerProperties;
import egovframework.liveapi.live.transcribe.domain.Segment;
import egovframework.liveapi.live.transcribe.dto.SegmentDto;
import egovframework.liveapi.live.transcribe.mapper.SegmentMapper;
import egovframework.liveapi.live.transcribe.repository.SegmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SseStreamClient {

	private final ServerProperties serverProps;
    private SegmentMapper segmentMapper;
    private final SegmentRepository segmentRepository;

	private final List<SegmentDto> segmentBuffer = new ArrayList<>();
	private final int FLUSH_THRESHOLD = 20;
	private long lastFlushTime = System.currentTimeMillis();

	@Async
    public SseEmitter connectToSseStream(String sessionId) {
    	String urlStr = serverProps.getBaseUrl() + ApiPaths.STREAM_SESSIONID.replace("{sessionId}", String.valueOf(sessionId));
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        new Thread(() -> {
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "text/event-stream");
                conn.setRequestProperty("Content-Type", "text/event-stream; charset=utf-8");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("data: ")) {
                            String json = line.substring("data: ".length());
                            handleTranscriptData(json);
                        }
                    }
                }
                emitter.complete();
            } catch (Exception e) {
                log.error("[SSE] SSE connection failed", e);
                emitter.completeWithError(e);
            }
        }).start();

        return emitter;
    }


    private void handleTranscriptData(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            JsonNode dataNode = root.get("data");
            if (dataNode == null || !dataNode.has("segments")) {
				return;
			}

            String sessionId = dataNode.get("id").asText();
            String groupId = dataNode.get("groupId").asText();
            String status = dataNode.get("status").asText();
            ArrayNode segmentsNode = (ArrayNode) dataNode.get("segments");

            for (JsonNode seg : segmentsNode) {
            	SegmentDto segment = new SegmentDto();
            	segment.setSessionId(sessionId);
            	segment.setSegmentId(seg.get("segmentId").asText());
            	segment.setSpeakerId(seg.get("speakerId").asInt());
            	segment.setStartTime(seg.get("startTime").asLong());
            	segment.setEndTime(seg.get("endTime").asLong());
            	segment.setDuration(seg.get("duration").asLong());
            	segment.setText(seg.get("text").asText());
            	segment.setFinal(seg.get("final").asBoolean());
                //segmentList.add(s);

                if (segment.isFinal()) {
                	//speechService.saveSegment(segment);
                	bufferAndFlush(segment);
                }
            }

            /**
            if ("DONE".equals(status)) {
            	TranscribeLive doc = TranscribeLive.builder()
            		    .sessionId(sessionId)
            		    .groupId(Integer.parseInt(groupId))
            		    .status(status)
            		    .clientLanguage("ko")
            		    .engine("HAIV")
            		    //.createAt(LocalDateTime.now())
            		    .updateAt(LocalDateTime.now())
            		    //.segments(segmentList)
            		    .build();

                log.info("✅ 자막 저장 완료: sessionId={}, segments={}", sessionId, segmentList.size());
            }
            */
        } catch (Exception e) {
            log.error("❌ 자막 처리 중 오류 발생", e);
        }
    }

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    private void bufferAndFlush(SegmentDto segmentDto) {
        segmentBuffer.add(segmentDto);
        if (segmentBuffer.size() >= FLUSH_THRESHOLD || System.currentTimeMillis() - lastFlushTime > 1000) {
            List<SegmentDto> bufferToSave = new ArrayList<>(segmentBuffer);
            executor.submit(() -> {
                List<Segment> segments = bufferToSave.stream()
                    .map(segmentMapper::toEntity)
                    .collect(Collectors.toList());
                segmentRepository.saveAll(segments);
            });
            segmentBuffer.clear();
            lastFlushTime = System.currentTimeMillis();
        }
    }


    public SseEmitter streamOnly(String sessionId) {
    	String urlStr = serverProps.getBaseUrl() + ApiPaths.STREAM_SESSIONID.replace("{sessionId}", String.valueOf(sessionId));
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        new Thread(() -> {
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "text/event-stream");
                conn.setRequestProperty("Content-Type", "text/event-stream; charset=utf-8");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("data: ")) {
                            String json = line.substring("data: ".length());
                            emitter.send(SseEmitter.event().name("transcript").data(json));
                        }
                    }
                }
                emitter.complete();
            } catch (Exception e) {
                log.error("[SSE] SSE connection failed", e);
                emitter.completeWithError(e);
            }
        }).start();

        return emitter;
    }

}
