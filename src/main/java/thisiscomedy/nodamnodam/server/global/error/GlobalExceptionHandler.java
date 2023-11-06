package thisiscomedy.nodamnodam.server.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NodamException.class)
    public ResponseEntity<ErrorResponse> nodamExceptionHandler(NodamException e) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(e.getErrorCode().getCode())
                .body(
                    new ErrorResponse(
                        errorCode.getCode(),
                        errorCode.getMessage()
                    )
                );
    }
}
