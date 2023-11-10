package thisiscomedy.nodamnodam.server.domain.smoke.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class AlreadyPressFailButton extends NodamException {

    public static final NodamException EXCEPTION = new AlreadyPressFailButton();

    public AlreadyPressFailButton() {
        super(ErrorCode.ALREADY_PRESS_FAIL_BUTTON);
    }
}
