package thisiscomedy.nodamnodam.server.domain.user.presentation.dto.response;

public record UserGetProfileResponse(
        String name,
        String email,
        String profileUrl,
        Integer noSmokeDay,
        Integer maximumContinuityNoSmoke,
        Integer saveMoney,
        Integer threeDayContinuityNoSmoke
) {}
