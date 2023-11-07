package thisiscomedy.nodamnodam.server.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.auth.repository.RefreshTokenRepository;

@Service
@RequiredArgsConstructor
public class RefreshTokenDeleteService {

    private final RefreshTokenRepository refreshTokenRepository;

    public String execute() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        refreshTokenRepository.deleteById(userId);

        return userId;
    }
}
