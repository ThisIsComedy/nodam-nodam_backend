package thisiscomedy.nodamnodam.server.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;

    public String createAccessToken(Long userId) {
        return createToken(userId, jwtProperties.getAccessTokenExp());
    }

    public TokenResponse createToken(Long userId) {
        String accessToken = createToken(userId, jwtProperties.getAccessTokenExp());
        String refreshToken = createToken(userId, jwtProperties.getRefreshTokenExp());

        return new TokenResponse(accessToken, refreshToken);
    }

    private String createToken(Long userId, Long exp) {
        Date now = new Date();
        Claims claims = Jwts.claims();
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + exp))
                .signWith(jwtProperties.getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
