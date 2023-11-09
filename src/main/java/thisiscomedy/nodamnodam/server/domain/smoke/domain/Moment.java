package thisiscomedy.nodamnodam.server.domain.smoke.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Moment {

    GO_TO_THE_OFFICE("출근길"),
    LEAVE_THE_OFFICE("퇴근길"),
    ON_WORK("업무 중"),
    AFTER_LUNCH("점심 시간 직후"),
    AFTER_DINNER("저녁 시간 직후"),
    NIGHT("밤"),
    DAWN("새벽"),
    AFTER_DRINKING("술 마신 후"),
    ETC("기타");

    private final String details;
}
