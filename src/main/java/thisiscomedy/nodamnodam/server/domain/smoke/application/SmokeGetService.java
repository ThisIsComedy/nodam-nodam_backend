package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.repository.SmokeRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmokeGetService {

    private final SmokeRepository smokeRepository;
    private final UserGetService userGetService;

    public List<GrassGetResponse> getGrass() {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        User user = userGetService.findById(userId);

        return smokeRepository.findByUser(user).stream()
                .map(GrassGetResponse::new)
                .toList();
    }
}
