package com.example.server.oauth.presentation;

import com.example.server.oauth.application.OauthService;
import com.example.server.oauth.domain.OauthMember;
import com.example.server.oauth.domain.OauthServerType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/oauth")
@RestController
public class OauthController {

    private final OauthService oauthService;

    @SneakyThrows
    @GetMapping("/{oauthServerType}")
    ResponseEntity<Void> redirectAuthCodeRequestUrl(
            @PathVariable OauthServerType oauthServerType,
            HttpServletResponse response
    ) {
        String redirectUrl = oauthService.getAuthCodeRequestUrl(oauthServerType);
        response.sendRedirect(redirectUrl);
        return ResponseEntity.ok().build();
    }

    // 추가
//    @GetMapping("/login/{oauthServerType}")
//    ResponseEntity<String> login(
//            @PathVariable OauthServerType oauthServerType,
//            @RequestParam("code") String code
//    ) {
//        String login = oauthService.login(oauthServerType, code);
//        return ResponseEntity.ok(login);
//    }
    @GetMapping("/login/{oauthServerType}")
    ResponseEntity<OauthMember> login(
            @PathVariable OauthServerType oauthServerType,
            @RequestParam("code") String code
    ) {
        OauthMember oauthMember = oauthService.login(oauthServerType, code);
        return ResponseEntity.ok(oauthMember);
    }
}
