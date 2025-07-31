package egovframework.liveapi.cmm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class ServerProperties {

    @Value("${gateway.protocol}")
    private String protocol;

    @Value("${gateway.url}")
    private String url;

    @Value("${gateway.port}")
    private int port;


    public String getBaseUrl() {
        return String.format("%s://%s:%d", protocol, url, port);
    }

}