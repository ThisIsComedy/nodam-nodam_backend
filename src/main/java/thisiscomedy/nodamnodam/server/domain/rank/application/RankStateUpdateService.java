package thisiscomedy.nodamnodam.server.domain.rank.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.user.application.UserGetService;
import thisiscomedy.nodamnodam.server.domain.user.application.UserSaveService;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;

@Service
@RequiredArgsConstructor
public class RankStateUpdateService {

    private final UserGetService userGetService;
    private final UserSaveService userSaveService;

    public Long execute() {
        User user = userGetService.getUser();
        return userSaveService.updateUser(user.updateRankState(!user.getIsRanked())).getId();
    }
}
