package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.auth.domain.RefreshToken;
import thisiscomedy.nodamnodam.server.domain.auth.repository.RefreshTokenRepository;
import thisiscomedy.nodamnodam.server.global.jwt.exception.InvalidTokenException;

@Service
@RequiredArgsConstructor
public class RefreshTokenUpdateService {

    private final RefreshTokenRepository refreshTokenRepository;

    public String execute(String originRefreshToken, String newAccessToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(originRefreshToken)
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);

        return refreshTokenRepository.save(refreshToken.updateAccessToken(newAccessToken)).getAccessToken();
    }
}
