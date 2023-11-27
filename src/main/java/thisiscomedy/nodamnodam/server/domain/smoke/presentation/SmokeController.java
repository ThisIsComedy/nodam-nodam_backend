package thisiscomedy.nodamnodam.server.domain.smoke.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeGetService;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeSaveService;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request.SmokeRequest;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.response.GrassGetResponse;

@RestController
@RequestMapping("/api/smoke")
@RequiredArgsConstructor
public class SmokeController {

    private final SmokeGetService smokeGetService;
    private final SmokeSaveService smokeSaveService;

    @GetMapping
    public ResponseEntity<GrassGetResponse> getGrass() {
        return ResponseEntity.ok(smokeGetService.getGrass());
    }

    @PostMapping
    public ResponseEntity<Long> pressSmokeButton(@RequestBody SmokeRequest request) {
        return ResponseEntity.ok(smokeSaveService.execute(request));
    }
}
