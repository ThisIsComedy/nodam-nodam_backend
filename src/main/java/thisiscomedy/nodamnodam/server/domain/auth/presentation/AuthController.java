package thisiscomedy.nodamnodam.server.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.auth.application.UserLoginService;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestParam String code) {
        return ResponseEntity.ok(userLoginService.execute(code));
    }
}
