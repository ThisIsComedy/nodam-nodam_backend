package thisiscomedy.nodamnodam.server.global.jwt.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class InvalidTokenException extends NodamException {

    public static final NodamException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
