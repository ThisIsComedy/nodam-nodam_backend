package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogoutService {

    private final RefreshTokenDeleteService refreshTokenDeleteService;

    public String execute() {
        return refreshTokenDeleteService.execute();
    }
}
