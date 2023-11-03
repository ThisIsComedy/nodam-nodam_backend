package thisiscomedy.nodamnodam.server.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    USER_INFO_UNSATISFIED(422, "가입 되었지만 추가 정보를 입력해야 합니다."),

    INVALID_TOKEN(403, "잘못된 토큰입니다."),
    EXPIRED_TOKEN(403, "만료된 토큰입니다."),
    OAUTH_TOKEN_NOT_FOUNT(404, "OAuth 액세스 토큰을 찾을 수 없습니다.");

    private final int code;
    private final String message;
}
