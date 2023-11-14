package thisiscomedy.nodamnodam.server.domain.stats.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeGetService;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;
import thisiscomedy.nodamnodam.server.domain.stats.repository.StatsRepository;

@Service
@RequiredArgsConstructor
public class StatsUpdateService {

    private final StatsRepository statsRepository;
    private final SmokeGetService smokeGetService;

    public void updateSmokeCount(Stats stats) {
        statsRepository.save(stats.updateSmokeCount());
    }
}
