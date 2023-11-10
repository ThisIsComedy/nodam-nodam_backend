package thisiscomedy.nodamnodam.server.domain.smoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thisiscomedy.nodamnodam.server.domain.smoke.domain.Smoke;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

import java.util.List;

@Repository
public interface SmokeRepository extends JpaRepository<Smoke, Long> {

    List<Smoke> findByUser(User user);
}
