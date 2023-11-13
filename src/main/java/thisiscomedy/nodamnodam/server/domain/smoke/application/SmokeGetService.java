package thisiscomedy.nodamnodam.server.domain.smoke.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;
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
        User user = userGetService.getUser();

        return smokeRepository.findByUser(user).stream()
                .map(GrassGetResponse::new)
                .toList();
    }

    public SmokeCauseResponse getCauseStats() {
        User user = userGetService.getUser();
        return smokeRepository.getSmokeCauseStats(user).get(0);
    }
}
