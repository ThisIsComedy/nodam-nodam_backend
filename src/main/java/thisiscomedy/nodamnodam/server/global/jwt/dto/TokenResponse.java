package thisiscomedy.nodamnodam.server.global.jwt.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {}
