package thisiscomedy.nodamnodam.server.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import thisiscomedy.nodamnodam.server.global.jwt.exception.ExpiredTokenException;
import thisiscomedy.nodamnodam.server.global.jwt.exception.InvalidTokenException;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        User principal = new User(claims.getSubject(), "", Collections.emptyList());

        return new UsernamePasswordAuthenticationToken(principal, token, Collections.emptyList());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");

        if (bearer == null || !bearer.startsWith(jwtProperties.getPrefix())) {
            throw InvalidTokenException.EXCEPTION;
        }

        return bearer.split(" ")[1].trim();
    }

    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (JwtException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
