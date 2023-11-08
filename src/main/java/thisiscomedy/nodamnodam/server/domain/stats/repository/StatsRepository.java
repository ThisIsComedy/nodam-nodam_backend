package thisiscomedy.nodamnodam.server.domain.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
}
