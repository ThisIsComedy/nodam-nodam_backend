package thisiscomedy.nodamnodam.server.domain.rank.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.rank.application.RankStateUpdateService;

@RestController
@RequestMapping("/api/rank")
@RequiredArgsConstructor
public class RankController {

    private final RankStateUpdateService rankStateUpdateService;

    @PostMapping
    public ResponseEntity<Long> updateRankState() {
        return ResponseEntity.ok(rankStateUpdateService.execute());
    }
}
