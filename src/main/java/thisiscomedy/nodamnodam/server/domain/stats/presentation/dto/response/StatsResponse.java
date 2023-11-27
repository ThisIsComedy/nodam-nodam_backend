package thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;

public record StatsResponse(
        StatsGetDetailsResponse response,
        GrassGetResponse grass,
        SmokeCauseResponse smokeCause
) {
}
