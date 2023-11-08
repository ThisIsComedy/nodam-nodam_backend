package thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;

import lombok.Getter;

@Getter
public class StatsGetBadgeResponse {

    private final Integer noSmokeDay;
    private final Integer maximumContinuityNoSmoke;
    private final Integer saveMoney;
    private final Integer threeDayContinuityNoSmoke;

    public StatsGetBadgeResponse(Stats stats) {
        this.noSmokeDay = stats.getNoSmokeDay();
        this.maximumContinuityNoSmoke = stats.getMaximumContinuityNoSmoke();
        this.saveMoney = stats.getSaveMoney();
        this.threeDayContinuityNoSmoke = stats.getThreeDayContinuityNoSmoke();
    }
}

