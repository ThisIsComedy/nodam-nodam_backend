package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class AlreadyUsedCodeException extends NodamException {

    public static final NodamException EXCEPTION = new AlreadyUsedCodeException();

    public AlreadyUsedCodeException() {
        super(ErrorCode.ALREADY_USED_CODE);
    }
}
