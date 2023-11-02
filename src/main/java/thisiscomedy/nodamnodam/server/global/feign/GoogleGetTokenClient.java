package thisiscomedy.nodamnodam.server.global.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import thisiscomedy.nodamnodam.server.global.feign.dto.request.GoogleTokenRequest;
import thisiscomedy.nodamnodam.server.global.feign.dto.response.GoogleTokenResponse;

@FeignClient(value = "GoogleGetTokenClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleGetTokenClient {

    @PostMapping
    GoogleTokenResponse getToken(GoogleTokenRequest request);
}
