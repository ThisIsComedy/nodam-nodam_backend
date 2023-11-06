package thisiscomedy.nodamnodam.server.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    ALREADY_REGISTERED_USER(409, "이미 가입된 유저입니다."),
    USER_INFO_UNSATISFIED(422, "가입 되었지만 추가 정보를 입력해야 합니다."),

    INVALID_TOKEN(403, "잘못된 토큰입니다."),
    EXPIRED_TOKEN(403, "만료된 토큰입니다."),
    LOGGED_OUT_TOKEN(403, "로그아웃 되어 사용할 수 없는 토큰입니다."),
    OAUTH_TOKEN_NOT_FOUNT(404, "OAuth 액세스 토큰을 찾을 수 없습니다."),

    BAD_REQUEST(401, "잘못된 파라미터"),
    INTERNAL_SERVER_ERROR(500, "서버 에러");

    private final int code;
    private final String message;
}
