package thisiscomedy.nodamnodam.server.global.error.exception;

import lombok.Getter;

@Getter
public class NodamException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String etc;

    public NodamException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.etc = null;
    }

    public NodamException(ErrorCode errorCode, String info) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.etc = info;
    }
}
