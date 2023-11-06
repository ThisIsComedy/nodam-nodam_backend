package thisiscomedy.nodamnodam.server.domain.auth.presentation.dto.request;

public record UserRegisterRequest(
        String name,
        String email,
        Integer smokePerDay,
        Integer cigarettePrice
) {}
