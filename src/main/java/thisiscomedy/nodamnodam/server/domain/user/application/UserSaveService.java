package thisiscomedy.nodamnodam.server.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;

    public void save(String email) {
        userRepository.save(User.builder().email(email).build());
    }

    public boolean userIsEmpty(String email) {
        return !userRepository.existsByEmail(email);
    }

    public boolean userAdditionalInfoIsEmpty(String email) {
        return userRepository.findByEmail(email).get().getName() == null;
    }
}
