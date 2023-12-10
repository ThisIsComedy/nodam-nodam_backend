package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.repository.SmokeRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.global.entity.BaseTimeEntity;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmokeGetService {

    private final SmokeRepository smokeRepository;
    private final UserGetService userGetService;

    public GrassGetResponse getGrass() {
        User user = userGetService.getUser();

        List<LocalDate> smoked = smokeRepository.findByUser(user).stream()
                .map(BaseTimeEntity::getCreatedAt)
                .toList();

        return new GrassGetResponse(
                user.getCreatedAt(),
                smoked
        );
    }

    public SmokeCauseResponse getCauseStats() {
        User user = userGetService.getUser();
        List<SmokeCauseResponse> smokeCauseResponseList = smokeRepository.getSmokeCauseStats(user);

        if (smokeCauseResponseList.isEmpty()) {
            return null;
        }

        return smokeCauseResponseList.get(0);
    }

    public boolean isSmokedToday() {
        return smokeRepository.existsByUser(userGetService.getUser());
    }

    public boolean isSmokedToday(User user) {
        return smokeRepository.existsByUser(user);
    }
}
