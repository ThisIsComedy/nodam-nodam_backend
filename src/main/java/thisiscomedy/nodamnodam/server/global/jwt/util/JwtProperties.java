package thisiscomedy.nodamnodam.server.global.jwt.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private final SecretKey secretKey;
    private final String prefix;
    private final Long accessTokenExp;
    private final Long refreshTokenExp;

    public JwtProperties(String secretKey, String prefix, Long accessTokenExp, Long refreshTokenExp) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        this.prefix = prefix;
        this.accessTokenExp = accessTokenExp;
        this.refreshTokenExp = refreshTokenExp;
    }
}
