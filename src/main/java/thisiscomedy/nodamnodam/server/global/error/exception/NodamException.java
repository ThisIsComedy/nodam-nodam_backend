package thisiscomedy.nodamnodam.server.global.error.exception;

import lombok.Getter;

@Getter
public class NodamException extends RuntimeException {

    private final ErrorCode errorCode;

    public NodamException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
