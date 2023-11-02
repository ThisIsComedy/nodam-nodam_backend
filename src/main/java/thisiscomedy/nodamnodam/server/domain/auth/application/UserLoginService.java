package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.domain.user.exception.OAuthTokenNotFoundException;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserInfoUnsatisfiedException;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserNotFoundException;
import thisiscomedy.nodamnodam.server.domain.user.repository.UserRepository;
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

    private final UserRepository userRepository;
    private final GoogleGetTokenClient googleGetTokenClient;
    private final GoogleAuthProperties googleAuthProperties;
    private final GoogleInfoClient googleInfoClient;
    private final JwtProvider jwtProvider;

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

        if (!userRepository.existsByEmail(email)) {
            register(email);
            throw UserNotFoundException.EXCEPTION;
        }

        if (userRepository.findByEmail(email).get().getName() == null) {
            throw UserInfoUnsatisfiedException.EXCEPTION;
        }

        return jwtProvider.createToken(email);
    }

    private void register(String email) {
        userRepository.save(User.builder().email(email).build());
    }
}
