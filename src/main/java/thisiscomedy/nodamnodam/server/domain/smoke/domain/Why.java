package thisiscomedy.nodamnodam.server.domain.smoke.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Why {
    WITHDRAWAL_SYMPTOM("금단현상"),
    HOW_ABOUT("지인 권유"),
    JUST_WANT("갑자기 피고 싶어서"),
    ETC("기타");

    private final String details;
}
