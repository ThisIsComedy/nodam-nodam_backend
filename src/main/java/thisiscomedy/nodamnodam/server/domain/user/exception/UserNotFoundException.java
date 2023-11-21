package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class UserNotFoundException extends NodamException {

    public static final NodamException EXCEPTION = new UserNotFoundException();

    public static final NodamException EXCEPTION(String email) {
        return new UserNotFoundException(email);
    }

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

    public UserNotFoundException(String email) {
        super(ErrorCode.USER_NOT_FOUND, email);
    }
}
