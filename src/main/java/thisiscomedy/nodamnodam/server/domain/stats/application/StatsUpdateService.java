package thisiscomedy.nodamnodam.server.domain.stats.application;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeGetService;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;
import thisiscomedy.nodamnodam.server.domain.stats.repository.StatsRepository;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsUpdateService {

    private final StatsRepository statsRepository;
    private final SmokeGetService smokeGetService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateStatsScheduling() {
        List<Stats> statsList = statsRepository.findAll();
        statsList.forEach(stats -> {
            User user = stats.getUser();

            if (smokeGetService.isSmokedToday(user)) {
                return;
            }

            statsRepository.save(stats.updateByScheduling());
        });
    }

    public void updateWhenSmoke(Stats stats) {
        statsRepository.save(stats.updateWhenSmoke());
    }
}
