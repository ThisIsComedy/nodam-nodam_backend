package thisiscomedy.nodamnodam.server.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.domain.user.presentation.dto.response.UserGetProfileResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserGetService userGetService;

    @GetMapping
    public ResponseEntity<User> get() {
        return ResponseEntity.ok(userGetService.getUser());
    }

    @GetMapping("/profile")
    public ResponseEntity<UserGetProfileResponse> getProfile() {
        return ResponseEntity.ok(userGetService.getProfile());
    }
}
