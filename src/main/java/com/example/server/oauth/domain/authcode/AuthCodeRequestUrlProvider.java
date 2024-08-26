package com.example.server.oauth.domain.authcode;

import com.example.server.oauth.domain.OauthServerType;

public interface AuthCodeRequestUrlProvider {
    OauthServerType supportServer();

    String provide();
}
