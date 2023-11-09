package thisiscomedy.nodamnodam.server.domain.smoke.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Where {

    IN_FRONT_OF_HOME("집 앞에서"),
    AT_WORK("직장에서"),
    RESTAURANT("식당에서"),
    ALLEY("골목에서"),
    PARK("공원에서"),
    INTERNET_CAFE("PC방에서"),
    KARAOKE("노래방"),
    ETC("기타");

    private final String details;
}
