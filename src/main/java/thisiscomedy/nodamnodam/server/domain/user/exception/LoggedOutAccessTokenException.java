package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class LoggedOutAccessTokenException extends NodamException {

    public static final NodamException EXCEPTION = new LoggedOutAccessTokenException();

    public LoggedOutAccessTokenException() {
        super(ErrorCode.LOGGED_OUT_TOKEN);
    }
}
