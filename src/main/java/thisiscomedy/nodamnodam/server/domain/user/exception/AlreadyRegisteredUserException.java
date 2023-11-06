package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class AlreadyRegisteredUserException extends NodamException {

    public static final NodamException EXCEPTION = new AlreadyRegisteredUserException();

    public AlreadyRegisteredUserException() {
        super(ErrorCode.ALREADY_REGISTERED_USER);
    }
}
