package thisiscomedy.nodamnodam.server.domain.auth.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thisiscomedy.nodamnodam.server.domain.auth.application.AccessTokenReissueService;
import thisiscomedy.nodamnodam.server.domain.auth.application.UserLoginService;
import thisiscomedy.nodamnodam.server.domain.auth.application.UserLogoutService;
import thisiscomedy.nodamnodam.server.domain.auth.application.UserRegisterService;
import thisiscomedy.nodamnodam.server.domain.auth.presentation.dto.request.UserRegisterRequest;
import thisiscomedy.nodamnodam.server.global.jwt.dto.TokenResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginService userLoginService;
    private final UserRegisterService userRegisterService;
    private final UserLogoutService userLogoutService;
    private final AccessTokenReissueService accessTokenReissueService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestParam String code) {
        return ResponseEntity.ok(userLoginService.execute(code));
    }

    @PutMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userRegisterService.execute(request));
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        return ResponseEntity.ok(userLogoutService.execute(request));
    }

    @PutMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(HttpServletRequest request) {
        return ResponseEntity.ok(accessTokenReissueService.execute(request));
    }
}
