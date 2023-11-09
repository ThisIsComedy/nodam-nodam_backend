package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request;

import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Moment;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Where;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Why;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

public record SmokeRequest(
        Moment moment,
        Where where,
        Why why
) {
    public Smoke toEntity(User user) {
        return Smoke.builder()
                .moment(moment)
                .where(where)
                .why(why)
                .user(user)
                .build();
    }
}
