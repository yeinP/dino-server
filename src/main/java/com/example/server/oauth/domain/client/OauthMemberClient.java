package com.example.server.oauth.domain.client;

import com.example.server.oauth.domain.OauthMember;
import com.example.server.oauth.domain.OauthServerType;

public interface OauthMemberClient {
    OauthServerType supportServer();

    OauthMember fetch(String code);
}
