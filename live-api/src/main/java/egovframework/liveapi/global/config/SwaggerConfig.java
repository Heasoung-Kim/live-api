package egovframework.liveapi.global.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Live API 문서")
                .version("1.0.0")
                .description("실시간 회의 시스템 API 명세서")
                .contact(new Contact()
                    .name("Live API Team")
                    .email("support@liveapi.com")
                    .url("https://liveapi.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0")))
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            .components(new Components()
                .addSecuritySchemes("Bearer Authentication",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("JWT 토큰을 입력하세요")))
            .addServersItem(new Server()
                .url("http://localhost:8080")
                .description("로컬 개발 서버"))
            .addServersItem(new Server()
                .url("https://api.liveapi.com")
                .description("프로덕션 서버"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("live-api")
            .pathsToMatch("/api/live/**")
            .build();
    }

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
            .group("인증 API")
            .pathsToMatch("/api/live/auth/**")
            .build();
    }

    @Bean
    public GroupedOpenApi conferenceApi() {
        return GroupedOpenApi.builder()
            .group("회의 API")
            .pathsToMatch("/api/live/groups/**", "/api/live/conference/**")
            .build();
    }

    @Bean
    public GroupedOpenApi speechApi() {
        return GroupedOpenApi.builder()
            .group("음성 API")
            .pathsToMatch("/api/live/speech/**")
            .build();
    }

    @Bean
    public GroupedOpenApi summaryApi() {
        return GroupedOpenApi.builder()
            .group("요약 API")
            .pathsToMatch("/api/live/summary/**")
            .build();
    }

    @Bean
    public GroupedOpenApi settingApi() {
        return GroupedOpenApi.builder()
            .group("설정 API")
            .pathsToMatch("/api/live/setting/**")
            .build();
    }
}