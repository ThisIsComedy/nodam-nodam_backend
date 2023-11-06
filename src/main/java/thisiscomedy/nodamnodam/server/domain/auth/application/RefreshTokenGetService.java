package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.auth.repository.RefreshTokenRepository;

@Service
@RequiredArgsConstructor
public class RefreshTokenGetService {

    private final RefreshTokenRepository refreshTokenRepository;

    public boolean isLoggedOutAccessToken(String accessToken) {
        return refreshTokenRepository.existsByAccessToken(accessToken);
    }
}
