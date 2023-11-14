package thisiscomedy.nodamnodam.server.domain.auth.application;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.exception.BadRequestException;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;
import thisiscomedy.nodamnodam.server.global.jwt.exception.ExpiredTokenException;
import thisiscomedy.nodamnodam.server.global.jwt.exception.InvalidTokenException;
import thisiscomedy.nodamnodam.server.global.jwt.util.JwtProvider;
import thisiscomedy.nodamnodam.server.global.jwt.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class AccessTokenReissueService {

    private final JwtProvider jwtProvider;
    private final JwtUtil jwtUtil;
    private final RefreshTokenUpdateService refreshTokenUpdateService;

    public TokenResponse execute(HttpServletRequest request) {
        try {
            String refreshToken = request.getHeader("Authorization-refresh").split(" ")[1].trim();
            String userId = jwtUtil.extractUserId(refreshToken);
            String newAccessToken = jwtProvider.createAccessToken(Long.valueOf(userId));

            refreshTokenUpdateService.execute(refreshToken, newAccessToken);

            return new TokenResponse(
                    newAccessToken,
                    refreshToken
            );
        } catch (NullPointerException e) {
            throw BadRequestException.EXCEPTION;
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (JwtException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
