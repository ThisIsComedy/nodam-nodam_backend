package thisiscomedy.nodamnodam.server.domain.stats.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeGetService;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetBadgeResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetDetailsResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetSummaryResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsResponse;
import thisiscomedy.nodamnodam.server.domain.stats.repository.StatsRepository;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsGetService {

    private final StatsRepository statsRepository;
    private final UserGetService userGetService;
    private final SmokeGetService smokeGetService;

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

    public StatsResponse getDetails() {
        User user = userGetService.getUser();

        StatsGetDetailsResponse detailsResponse = statsRepository.findByUser(user)
                .map(StatsGetDetailsResponse::new)
                .orElse(null);

        List<GrassGetResponse> grassGetResponse = smokeGetService.getGrass();

        SmokeCauseResponse smokeCauseResponse = smokeGetService.getCauseStats();

        return new StatsResponse(
                detailsResponse,
                grassGetResponse,
                smokeCauseResponse
        );
    }
}
