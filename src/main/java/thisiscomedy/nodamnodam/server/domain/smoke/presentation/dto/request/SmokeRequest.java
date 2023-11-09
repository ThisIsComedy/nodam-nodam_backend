package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request;

import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Moment;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Place;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Why;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

public record SmokeRequest(
        Moment moment,
        Place place,
        Why why
) {
    public Smoke toEntity(User user) {
        return Smoke.builder()
                .moment(moment)
                .place(place)
                .why(why)
                .user(user)
                .build();
    }
}
