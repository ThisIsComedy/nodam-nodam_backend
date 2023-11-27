package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response;

import java.time.LocalDate;
import java.util.List;

public record GrassGetResponse(
        LocalDate userCreatedAt,
        List<UserSmokedAtResponse> userSmokedAtResponses
) {}
