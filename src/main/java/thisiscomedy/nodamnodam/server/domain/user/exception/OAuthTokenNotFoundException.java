package thisiscomedy.nodamnodam.server.domain.user.exception;

import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

public class OAuthTokenNotFoundException extends NodamException {

    public static final NodamException EXCEPTION = new OAuthTokenNotFoundException();

    public OAuthTokenNotFoundException() {
        super(ErrorCode.OAUTH_TOKEN_NOT_FOUNT);
    }
}
