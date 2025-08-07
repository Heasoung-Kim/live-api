package egovframework.liveapi.live.content.service;

import java.util.List;

import egovframework.liveapi.live.content.dto.LiveContentDto;

public interface LiveContentService {

    String createLiveContent(LiveContentDto dto);

    LiveContentDto getLiveContentById(String id);

    List<LiveContentDto> getAllLiveContents();

    void updateLiveContent(LiveContentDto dto);
    
    void updateStatus(String id, String status);

    void endLiveContent(String id);

    void softDelete(String id);
}
