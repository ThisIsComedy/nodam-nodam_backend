package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class UserInfoUnsatisfiedException extends NodamException {

    public static final NodamException EXCEPTION = new UserInfoUnsatisfiedException();

    public static NodamException EXCEPTION(String email) {
        return new UserInfoUnsatisfiedException(email);
    }

    public UserInfoUnsatisfiedException() {
        super(ErrorCode.USER_INFO_UNSATISFIED);
    }

    public UserInfoUnsatisfiedException(String email) {
        super(ErrorCode.USER_INFO_UNSATISFIED, email);
    }
}
