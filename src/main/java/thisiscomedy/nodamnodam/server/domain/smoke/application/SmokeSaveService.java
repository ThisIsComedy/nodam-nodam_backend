package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request.SmokeRequest;
import thisiscomedy.nodamnodam.server.domain.smoke.repository.SmokeRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

@Service
@RequiredArgsConstructor
public class SmokeSaveService {

    private final SmokeRepository smokeRepository;
    private final UserGetService userGetService;

    public Long execute(SmokeRequest request) {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        User userEntity = userGetService.findById(userId);

        return smokeRepository.save(request.toEntity(userEntity)).getId();
    }
}
