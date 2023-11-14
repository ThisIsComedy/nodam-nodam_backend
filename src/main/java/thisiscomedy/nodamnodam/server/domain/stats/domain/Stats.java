package thisiscomedy.nodamnodam.server.domain.stats.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.global.entity.BaseTimeEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Stats extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer noSmokeDay;

    @Column(nullable = false)
    private Integer saveMoney;

    @Column(nullable = false)
    private Integer currentContinuityNoSmoke;

    @Column(nullable = false)
    private Integer maximumContinuityNoSmoke;

    @Column(nullable = false)
    private Integer threeDayContinuityNoSmoke;

    @Column(nullable = false)
    private Integer smokeCount;

    @Builder
    public Stats(User user, Integer noSmokeDay, Integer saveMoney, Integer currentContinuityNoSmoke, Integer maximumContinuityNoSmoke, Integer threeDayContinuityNoSmoke, Integer smokeCount) {
        this.user = user;
        this.noSmokeDay = noSmokeDay;
        this.saveMoney = saveMoney;
        this.currentContinuityNoSmoke = currentContinuityNoSmoke;
        this.maximumContinuityNoSmoke = maximumContinuityNoSmoke;
        this.threeDayContinuityNoSmoke = threeDayContinuityNoSmoke;
        this.smokeCount = smokeCount;
    }

    public Stats updateByScheduling() {
        int cigarettePrice = user.getCigarettePrice();
        int smokePerDay = user.getSmokePerDay();

        int packsPerDay = smokePerDay / 20;
        int remainingCigarettes = smokePerDay % 20;

        saveMoney += packsPerDay * cigarettePrice + cigarettePrice / (20 - remainingCigarettes);
        noSmokeDay += 1;
        currentContinuityNoSmoke += 1;
        maximumContinuityNoSmoke += 1;

        LocalDate userNoSmokeStartAt = user.getNoSmokeStartAt();
        LocalDate currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        threeDayContinuityNoSmoke = Math.abs(Math.toIntExact(ChronoUnit.DAYS.between(currentDate, userNoSmokeStartAt))) / 3;

        return this;
    }

    public Stats updateWhenSmoke() {
        this.smokeCount += 1;
        this.currentContinuityNoSmoke = 0;
        this.threeDayContinuityNoSmoke = 0;
        return this;
    }
}
