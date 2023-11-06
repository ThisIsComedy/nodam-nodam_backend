package thisiscomedy.nodamnodam.server.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import thisiscomedy.nodamnodam.server.global.security.auth.AuthDetails;
import thisiscomedy.nodamnodam.server.global.security.auth.AuthDetailsService;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = (AuthDetails) authDetailsService.loadUserByUsername(extractEmail(token));

        return new UsernamePasswordAuthenticationToken(authDetails, token, Collections.emptyList());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");

        if (bearer == null || !bearer.startsWith(jwtProperties.getPrefix())) {
            return null;
        }

        return bearer.split(" ")[1].trim();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return getClaims(token).get("email").toString();
    }

    public Long getRefreshTokenExp() {
        return jwtProperties.getRefreshTokenExp();
    }
}
