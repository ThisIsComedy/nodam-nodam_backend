package thisiscomedy.nodamnodam.server.domain.rank.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.rank.application.RankGetService;
import thisiscomedy.nodamnodam.server.domain.rank.application.RankStateUpdateService;
import thisiscomedy.nodamnodam.server.domain.rank.presentation.dto.response.RankResponse;

import java.util.List;

@RestController
@RequestMapping("/api/rank")
@RequiredArgsConstructor
public class RankController {

    private final RankGetService rankGetService;
    private final RankStateUpdateService rankStateUpdateService;

    @GetMapping
    public ResponseEntity<List<RankResponse>> getRank() {
        return ResponseEntity.ok(rankGetService.execute());
    }

    @PostMapping
    public ResponseEntity<Long> updateRankState() {
        return ResponseEntity.ok(rankStateUpdateService.execute());
    }
}
