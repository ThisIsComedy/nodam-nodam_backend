package thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response;

import thisiscomedy.nodamnodam.server.domain.smoke.domain.Moment;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Place;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Why;

public record SmokeCauseResponse(
        String when,
        Long whenCount,
        String where,
        Long whereCount,
        String why,
        Long whyCount
) {
    public SmokeCauseResponse(Moment when, Long whenCount, Place where, Long whereCount, Why why, Long whyCount) {
        this(
                when.getDetails(), whenCount,
                where.getDetails(),whereCount,
                why.getDetails(), whyCount
        );
    }
}
