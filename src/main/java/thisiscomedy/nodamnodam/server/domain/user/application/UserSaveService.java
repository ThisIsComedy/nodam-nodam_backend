package thisiscomedy.nodamnodam.server.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.auth.presentation.dto.request.UserRegisterRequest;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.domain.user.exception.UserNotFoundException;
import thisiscomedy.nodamnodam.server.domain.user.repository.UserRepository;
import thisiscomedy.nodamnodam.server.global.feign.dto.response.GoogleInfoResponse;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;

    public void save(GoogleInfoResponse response) {
        userRepository.save(
                User.builder()
                        .email(response.email())
                        .profileUrl(response.picture())
                        .build()
        );
    }

    public boolean userIsEmpty(String email) {
        return !userRepository.existsByEmail(email);
    }

    public boolean userAdditionalInfoIsEmpty(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return user.getName() == null
                && user.getSmokePerDay() == null
                && user.getCigarettePrice() == null;
    }

    public Long updateUser(UserRegisterRequest request) {
        User user = userRepository.findByEmail(request.email()).get();

        return userRepository.save(user.update(request)).getId();
    }
}
