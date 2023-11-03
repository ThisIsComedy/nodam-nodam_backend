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

    public String createAccessToken(String email) {
        return createToken(email, jwtProperties.getAccessTokenExp());
    }

    public TokenResponse createToken(String email) {
        String accessToken = createToken(email, jwtProperties.getAccessTokenExp());
        String refreshToken = createToken(email, jwtProperties.getRefreshTokenExp());

        return new TokenResponse(accessToken, refreshToken);
    }

    private String createToken(String email, Long exp) {
        Date now = new Date();
        Claims claims = Jwts.claims();
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + exp))
                .signWith(jwtProperties.getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
