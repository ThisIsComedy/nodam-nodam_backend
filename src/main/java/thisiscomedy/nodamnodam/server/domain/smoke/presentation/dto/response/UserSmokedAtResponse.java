package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;

import java.time.LocalDate;

public record UserSmokedAtResponse(
        LocalDate at
) {
    public UserSmokedAtResponse(Smoke smoke) {
        this(smoke.getCreatedAt());
    }
}