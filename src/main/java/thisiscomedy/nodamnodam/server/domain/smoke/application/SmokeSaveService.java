package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.exception.AlreadyPressFailButton;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request.SmokeRequest;
import thisiscomedy.nodamnodam.server.domain.smoke.repository.SmokeRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SmokeSaveService {

    private final SmokeRepository smokeRepository;
    private final UserGetService userGetService;

    public Long execute(SmokeRequest request) {
        User userEntity = userGetService.getUser();

        if (smokeRepository.existsByCreatedAt(
                new Date().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())) {
            throw AlreadyPressFailButton.EXCEPTION;
        }

        return smokeRepository.save(request.toEntity(userEntity)).getId();
    }
}
