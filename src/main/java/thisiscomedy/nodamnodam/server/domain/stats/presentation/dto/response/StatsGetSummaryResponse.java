package thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response;

import lombok.Getter;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
public class StatsGetSummaryResponse {

    private final long threeDayCurrentState;
    private final int threeDayContinuityNoSmoke;
    private final int saveMoney;

    public StatsGetSummaryResponse(Stats stats) {
        LocalDate userCreated = stats.getUser().getNoSmokeStartAt();
        LocalDate currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        this.threeDayCurrentState = ChronoUnit.DAYS.between(currentDate, userCreated) % 3 + 1;
        this.threeDayContinuityNoSmoke = stats.getThreeDayContinuityNoSmoke();
        this.saveMoney = stats.getSaveMoney();
    }
}
