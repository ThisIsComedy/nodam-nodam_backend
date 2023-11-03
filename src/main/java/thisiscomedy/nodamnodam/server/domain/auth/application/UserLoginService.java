package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.application.UserSaveService;
import thisiscomedy.nodamnodam.server.domain.user.exception.OAuthTokenNotFoundException;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserInfoUnsatisfiedException;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserNotFoundException;
import thisiscomedy.nodamnodam.server.global.config.GoogleAuthProperties;
import thisiscomedy.nodamnodam.server.global.feign.GoogleGetTokenClient;
import thisiscomedy.nodamnodam.server.global.feign.GoogleInfoClient;
import thisiscomedy.nodamnodam.server.global.feign.dto.request.GoogleTokenRequest;
import thisiscomedy.nodamnodam.server.global.feign.dto.response.GoogleTokenResponse;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;
import thisiscomedy.nodamnodam.server.global.jwt.util.JwtProvider;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserSaveService userSaveService;
    private final GoogleGetTokenClient googleGetTokenClient;
    private final GoogleAuthProperties googleAuthProperties;
    private final GoogleInfoClient googleInfoClient;
    private final JwtProvider jwtProvider;
    private final RefreshTokenSaveService refreshTokenSaveService;

    public TokenResponse execute(String code) {
        code = code.replace("%2f", "/");

        GoogleTokenResponse response = googleGetTokenClient.getToken(
                new GoogleTokenRequest(
                        googleAuthProperties.getClientId(),
                        googleAuthProperties.getClientSecret(),
                        code,
                        googleAuthProperties.getGrantType(),
                        googleAuthProperties.getRedirectUri()
                )
        );

        String googleAccessToken = response.accessToken();

        if (googleAccessToken == null) {
            throw OAuthTokenNotFoundException.EXCEPTION;
        }

        String email = googleInfoClient.getUserInfo(googleAccessToken).email();

        if (userSaveService.userIsEmpty(email)) {
            userSaveService.save(email);
            throw UserNotFoundException.EXCEPTION;
        }

        if (userSaveService.userAdditionalInfoIsEmpty(email)) {
            throw UserInfoUnsatisfiedException.EXCEPTION;
        }

        TokenResponse tokenResponse = jwtProvider.createToken(email);

        refreshTokenSaveService.execute(tokenResponse);

        return tokenResponse;
    }
}
