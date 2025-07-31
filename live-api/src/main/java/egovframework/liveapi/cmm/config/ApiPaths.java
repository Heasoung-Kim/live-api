package egovframework.liveapi.cmm.config;

public class ApiPaths {

    public static final String HEALTH = "/health";
    public static final String STATUS = "/status";
    public static final String METRICS = "/metrics";
    public static final String SESSIONS = "/sessions";

    public static final String GROUPS = "/groups";
    public static final String GROUP_DETAIL = "/groups/{groupId}";
    public static final String MICROPHONES = "/microphones";
    public static final String MICROPHONES_MIC = "/microphones/{groupId}/{micId}";

    public static final String SESSION = "/sessions/";
    public static final String SESSION_START = "/groups/{groupId}/sessions/start";
    public static final String SESSION_STREAM = "/sse/transcripts/stream/session/{session_id}";
    public static final String SESSION_STOP = "/groups/{groupId}/sessions/stop";

    public static final String STREAM_SESSIONID = "/sse/transcripts/stream/session/{sessionId}";
    public static final String STREAM_GROUPID = "/sse/transcripts/stream/group/{group_id}";


    public static final String DEBUG_CONNECTIONS = "/debug/connections";

    private ApiPaths() {
        // 생성 방지
    }

}
