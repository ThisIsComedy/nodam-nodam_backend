package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.exception.AlreadyPressFailButton;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request.SmokeRequest;
import thisiscomedy.nodamnodam.server.domain.smoke.repository.SmokeRepository;
import thisiscomedy.nodamnodam.server.domain.stats.application.StatsGetService;
import thisiscomedy.nodamnodam.server.domain.stats.application.StatsUpdateService;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.application.UserSaveService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SmokeSaveService {

    private final SmokeRepository smokeRepository;
    private final UserGetService userGetService;
    private final UserSaveService userSaveService;
    private final StatsGetService statsGetService;
    private final StatsUpdateService statsUpdateService;

    public Long execute(SmokeRequest request) {
        User user = userGetService.getUser();

        if (smokeRepository.existsByCreatedAt(
                new Date().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())) {
            throw AlreadyPressFailButton.EXCEPTION;
        }

        userSaveService.updateNoSmokeStartAt(user);

        statsUpdateService.updateSmokeCount(statsGetService.getStats(user));

        return smokeRepository.save(request.toEntity(user)).getId();
    }
}
