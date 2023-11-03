package thisiscomedy.nodamnodam.server.domain.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String userId;

    @Indexed
    private String token;

    private String accessToken;

    @TimeToLive
    private Long ttl;
}
