package thisiscomedy.nodamnodam.server.domain.smoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SmokeRepository extends JpaRepository<Smoke, Long> {

    List<Smoke> findByUser(User user);

    boolean existsByCreatedAt(LocalDate date);

    @Query(value = """
        select new thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.SmokeCauseResponse(
            s1.moment, s1.count,
            s2.place, s2.count,
            s3.why, s3.count
        )
        from (
            select s.moment as moment, count(s.moment) as count
            from Smoke s
            where s.user = :user
            group by s.moment
            order by count(s.moment) desc
        ) s1,
        (
            select s.place as place, count(s.place) as count
            from Smoke s
            where s.user = :user
            group by s.place
            order by count(s.place)
        ) s2,
        (
            select s.why as why, count(s.why) as count
            from Smoke s
            where s.user = :user
            group by s.why
            order by count(s.why) desc
        ) s3
    """)
    List<SmokeCauseResponse> getSmokeCauseStats(@Param("user") User user);
}
