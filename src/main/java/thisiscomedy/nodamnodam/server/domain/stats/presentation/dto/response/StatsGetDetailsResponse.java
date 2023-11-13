package thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response;

import lombok.Getter;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;

@Getter
public class StatsGetDetailsResponse {

    private final int noSmokeDay;
    private final int saveMoney;
    private final int continuityNoSmoke;
    private final int maximumContinuityNoSmoke;
    private final int threeDayContinuityNoSmoke;
    private final int smokeCount;

    public StatsGetDetailsResponse(Stats stats) {
        this.noSmokeDay = stats.getNoSmokeDay();
        this.saveMoney = stats.getSaveMoney();
        this.continuityNoSmoke = stats.getCurrentContinuityNoSmoke();
        this.maximumContinuityNoSmoke = stats.getMaximumContinuityNoSmoke();
        this.threeDayContinuityNoSmoke = stats.getThreeDayContinuityNoSmoke();
        this.smokeCount = stats.getSmokeCount();
    }
}
