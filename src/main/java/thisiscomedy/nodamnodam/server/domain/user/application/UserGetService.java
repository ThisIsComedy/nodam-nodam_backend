package thisiscomedy.nodamnodam.server.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.stats.application.StatsGetService;
import thisiscomedy.nodamnodam.server.domain.stats.presentation.dto.response.StatsGetBadgeResponse;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserNotFoundException;
import thisiscomedy.nodamnodam.server.domain.user.presentation.dto.response.UserGetProfileResponse;
import thisiscomedy.nodamnodam.server.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;
    private final StatsGetService statsGetService;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public UserGetProfileResponse getProfile() {
        Long userId = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        StatsGetBadgeResponse badgeInfo = statsGetService.getBadge(user);

        return new UserGetProfileResponse(
                user.getName(),
                user.getEmail(),
                user.getProfileUrl(),
                badgeInfo.getNoSmokeDay(),
                badgeInfo.getMaximumContinuityNoSmoke(),
                badgeInfo.getSaveMoney(),
                badgeInfo.getThreeDayContinuityNoSmoke()
        );
    }
}
