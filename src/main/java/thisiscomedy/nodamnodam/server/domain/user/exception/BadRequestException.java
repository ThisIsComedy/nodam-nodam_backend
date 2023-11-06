package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class BadRequestException extends NodamException {

    public static final NodamException EXCEPTION = new BadRequestException();

    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
