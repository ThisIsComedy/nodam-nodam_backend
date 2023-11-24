package thisiscomedy.nodamnodam.server.domain.stats.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import thisiscomedy.nodamnodam.server.domain.rank.presentation.dto.response.RankResponse;
import thisiscomedy.nodamnodam.server.domain.stats.domain.Stats;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

    Optional<Stats> findByUser(User user);

    @Query(value = """
        select new thisiscomedy.nodamnodam.server.domain.rank.presentation.dto.response.RankResponse(
            s.user.name, s.user.profileUrl, s.threeDayContinuityNoSmoke
        )
        from Stats s
        order by s.threeDayContinuityNoSmoke desc
    """)
    List<RankResponse> getRank(Pageable pageable);
}
