package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response;

import lombok.Getter;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;

import java.time.LocalDate;

@Getter
public class GrassGetResponse {

    private final LocalDate at;

    public GrassGetResponse(Smoke smoke) {
        this.at = smoke.getCreatedAt();
    }
}
