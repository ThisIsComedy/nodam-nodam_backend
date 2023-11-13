package thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;

import java.util.List;

public record StatsResponse(
        StatsGetDetailsResponse response,
        List<GrassGetResponse> grass,
        SmokeCauseResponse smokeCause
) {
}
