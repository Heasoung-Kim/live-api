package egovframework.liveapi.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.liveapi.security.dto.LoginRequest;
import egovframework.liveapi.security.dto.TokenResponse;
import egovframework.liveapi.security.jwt.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/live/auth")
@RequiredArgsConstructor
@Tag(name = "인증 API", description = "사용자 인증 관련 API")
public class AuthController {

    private final JwtTokenProvider jwtProvider;

    @PostMapping("/login")
    @Operation(
        summary = "사용자 로그인",
        description = "사용자명과 비밀번호로 로그인하여 JWT 토큰을 발급받습니다."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "로그인 성공",
            content = @Content(schema = @Schema(implementation = TokenResponse.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청"
        )
    })
    public ResponseEntity<TokenResponse> login(
            @RequestBody(description = "로그인 정보", required = true)
            @org.springframework.web.bind.annotation.RequestBody LoginRequest request) {
        // 실제 인증은 생략, 예시로 무조건 성공 처리
        // 실제로는 DB 조회, 패스워드 비교 등 필요
        String token = jwtProvider.createToken(request.getUsername());

        return ResponseEntity.ok(new TokenResponse(token));
    }

    @GetMapping("/check")
    @Operation(
        summary = "토큰 유효성 검사",
        description = "현재 JWT 토큰의 유효성을 검사합니다."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "토큰 유효"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "토큰 무효"
        )
    })
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> checkToken() {
        return ResponseEntity.ok("Token is valid");
    }
}