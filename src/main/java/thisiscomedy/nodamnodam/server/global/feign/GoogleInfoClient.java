package thisiscomedy.nodamnodam.server.global.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thisiscomedy.nodamnodam.server.global.feign.dto.response.GoogleInfoResponse;

@FeignClient(value = "GoogleInfoClient", url = "https://www.googleapis.com")
public interface GoogleInfoClient {

    @GetMapping("/oauth2/v1/userinfo?access_token={accessToken}")
    GoogleInfoResponse getUserInfo(@PathVariable("accessToken") String token);
}
