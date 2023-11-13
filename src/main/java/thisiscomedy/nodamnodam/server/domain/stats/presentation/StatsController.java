package thisiscomedy.nodamnodam.server.domain.stats.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.stats.application.StatsGetService;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetSummaryResponse;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsResponse;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {

    private final StatsGetService statsGetService;

    @GetMapping("/summary")
    public ResponseEntity<StatsGetSummaryResponse> getSummary() {
        return ResponseEntity.ok(statsGetService.getSummary());
    }

    @GetMapping("/details")
    public ResponseEntity<StatsResponse> getDetails() {
        return ResponseEntity.ok(statsGetService.getDetails());
    }
}
