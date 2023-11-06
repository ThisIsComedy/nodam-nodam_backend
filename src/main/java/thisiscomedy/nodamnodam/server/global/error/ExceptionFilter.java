package thisiscomedy.nodamnodam.server.global.error;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import thisiscomedy.nodamnodam.server.global.error.exception.ErrorCode;
import thisiscomedy.nodamnodam.server.global.error.exception.NodamException;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (NodamException e) {
            writeErrorCode(response, e.getErrorCode());
        } catch (ExpiredJwtException e) {
            writeErrorCode(response, ErrorCode.EXPIRED_TOKEN);
        } catch (JwtException e) {
            writeErrorCode(response, ErrorCode.INVALID_TOKEN);
        } catch (Exception e) {
            e.printStackTrace();
            writeErrorCode(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void writeErrorCode(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse(
                errorCode.getCode(), errorCode.getMessage()
        );

        response.setStatus(errorResponse.code());
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponse.toString());
    }
}
