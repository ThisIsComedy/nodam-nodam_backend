package thisiscomedy.nodamnodam.server.domain.stats.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;
import thisiscomedy.nodamnodam.server.domain.stats.repository.StatsRepository;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

@Service
@RequiredArgsConstructor
@Transactional
public class StatsSaveService {

    private final StatsRepository statsRepository;

    public void init(User user) {
        statsRepository.save(
                Stats.builder()
                        .user(user)
                        .noSmokeDay(1)
                        .saveMoney(user.getCigarettePrice())
                        .maximumContinuityNoSmoke(1)
                        .currentContinuityNoSmoke(1)
                        .threeDayContinuityNoSmoke(0)
                        .smokeCount(0)
                        .build()
        );
    }
}
