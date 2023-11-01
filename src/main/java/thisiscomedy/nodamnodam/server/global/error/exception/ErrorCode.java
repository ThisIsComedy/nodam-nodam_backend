package thisiscomedy.nodamnodam.server.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다.");

    private final int code;
    private final String message;
}
