package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;

import java.time.LocalDate;

public record GrassGetResponse(
        LocalDate at
) {
    public GrassGetResponse(Smoke smoke) {
        this(smoke.getCreatedAt());
    }
}