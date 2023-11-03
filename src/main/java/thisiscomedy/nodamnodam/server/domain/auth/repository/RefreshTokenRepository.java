package thisiscomedy.nodamnodam.server.domain.auth.repository;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import thisiscomedy.nodamnodam.server.domain.auth.domain.RefreshToken;

@EnableRedisRepositories
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
