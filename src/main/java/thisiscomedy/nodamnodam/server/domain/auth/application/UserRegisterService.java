package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thisiscomedy.nodamnodam.server.domain.auth.presentation.dto.request.UserRegisterRequest;
import thisiscomedy.nodamnodam.server.domain.user.application.UserSaveService;
import thisiscomedy.nodamnodam.server.domain.user.exception.AlreadyRegisteredUserException;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;
import thisiscomedy.nodamnodam.server.global.jwt.util.JwtProvider;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRegisterService {

    private final UserSaveService userSaveService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenSaveService refreshTokenSaveService;

    public TokenResponse execute(UserRegisterRequest request) {
        if (!userSaveService.userAdditionalInfoIsEmpty(request.email())) {
            throw AlreadyRegisteredUserException.EXCEPTION;
        }

        Long userId = userSaveService.updateUser(request);

        TokenResponse tokenResponse = jwtProvider.createToken(userId);

        refreshTokenSaveService.execute(tokenResponse, userId.toString());

        return tokenResponse;
    }
}
