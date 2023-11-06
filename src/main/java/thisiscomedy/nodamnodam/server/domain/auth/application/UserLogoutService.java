package thisiscomedy.nodamnodam.server.domain.auth.application;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.exception.BadRequestException;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;

@Service
@RequiredArgsConstructor
public class UserLogoutService {

    private final RefreshTokenSaveService refreshTokenSaveService;

    public String execute(HttpServletRequest request) {
        try {
            String accessToken = request.getHeader("Authorization").split(" ")[1].trim();
            String refreshToken = request.getHeader("Authorization-refresh").split(" ")[1].trim();

            refreshTokenSaveService.execute(
                    new TokenResponse(accessToken, refreshToken)
            );

            return "SUCCESS";
        } catch (NullPointerException e) {
            throw BadRequestException.EXCEPTION;
        }
    }
}
