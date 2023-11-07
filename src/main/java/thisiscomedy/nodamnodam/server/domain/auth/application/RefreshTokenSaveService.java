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

    public void execute(TokenResponse response, String userId) {
        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userId(userId)
                        .token(response.refreshToken())
                        .accessToken(response.accessToken())
                        .ttl(jwtUtil.getRefreshTokenExp())
                        .build()
        );
    }
}


