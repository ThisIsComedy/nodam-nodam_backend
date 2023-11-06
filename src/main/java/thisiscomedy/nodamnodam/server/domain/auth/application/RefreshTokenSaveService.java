package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.auth.domain.RefreshToken;
import thisiscomedy.nodamnodam.server.domain.auth.repository.RefreshTokenRepository;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;
import thisiscomedy.nodamnodam.server.global.jwt.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class RefreshTokenSaveService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;

    public void execute(TokenResponse tokenResponse) {
        System.out.println(tokenResponse.getAccessToken());
        String userId = jwtUtil.extractEmail(tokenResponse.getAccessToken());

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userId(userId)
                        .token(tokenResponse.getRefreshToken())
                        .accessToken(tokenResponse.getAccessToken())
                        .ttl(jwtUtil.getRefreshTokenExp())
                        .build()
        );
    }
}

