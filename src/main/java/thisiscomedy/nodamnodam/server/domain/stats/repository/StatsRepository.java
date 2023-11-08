package thisiscomedy.nodamnodam.server.domain.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.Optional;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

    Optional<Stats> findByUser(User user);
}
