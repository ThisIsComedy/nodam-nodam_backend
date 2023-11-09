package thisiscomedy.nodamnodam.server.domain.smoke.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.smoke.application.SmokeSaveService;
import thisiscomedy.nodamnodam.server.domain.smoke.presentation.dto.request.SmokeRequest;

@RestController
@RequestMapping("/api/smoke")
@RequiredArgsConstructor
public class SmokeController {

    private final SmokeSaveService smokeSaveService;

    @PostMapping
    public ResponseEntity<Long> pressSmokeButton(@RequestBody SmokeRequest request) {
        return ResponseEntity.ok(smokeSaveService.execute(request));
    }
}
