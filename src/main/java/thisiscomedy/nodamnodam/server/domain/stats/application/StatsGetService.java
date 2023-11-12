package thisiscomedy.nodamnodam.server.domain.stats.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetBadgeResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetSummaryResponse;
import thisiscomedy.nodamnodam.server.domain.stats.repository.StatsRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

@Service
@RequiredArgsConstructor
public class StatsGetService {

    private final StatsRepository statsRepository;
    private final UserGetService userGetService;

    public StatsGetBadgeResponse getBadge(User user) {
        return statsRepository.findByUser(user)
                .map(StatsGetBadgeResponse::new)
                .orElse(null);
    }

    public StatsGetSummaryResponse getSummary() {
        User user = userGetService.getUser();

        return statsRepository.findByUser(user)
                .map(StatsGetSummaryResponse::new)
                .orElse(null);
    }
}
