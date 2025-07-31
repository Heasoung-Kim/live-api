package egovframework.liveapi.security.service;

import org.springframework.stereotype.Service;

import egovframework.liveapi.security.dto.LoginRequest;
import egovframework.liveapi.security.dto.TokenResponse;
import egovframework.liveapi.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtProvider;

    public TokenResponse login(LoginRequest request) {
        // 🔐 여기서는 임시 하드코딩. 실제로는 DB에서 사용자 검증해야 함
        if (!"admin".equals(request.getUsername()) || !"1234".equals(request.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다.");
        }

        // ✅ 토큰 발급
        String token = jwtProvider.createToken(request.getUsername());

        return new TokenResponse(token);
    }
}
