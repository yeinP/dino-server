package com.example.server.oauth.application;

import com.example.server.oauth.domain.OauthMember;
import com.example.server.oauth.domain.OauthMemberRepository;
import com.example.server.oauth.domain.OauthServerType;
import com.example.server.oauth.domain.authcode.AuthCodeRequestUrlProviderComposite;
import com.example.server.oauth.domain.client.OauthMemberClientComposite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService {
    private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;
    private final OauthMemberClientComposite oauthMemberClientComposite;
    private final OauthMemberRepository oauthMemberRepository;

    public String getAuthCodeRequestUrl(OauthServerType oauthServerType) {
        return authCodeRequestUrlProviderComposite.provide(oauthServerType);
    }

//    public String login(OauthServerType oauthServerType, String authCode) {
//        OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType, authCode);
//        OauthMember saved = oauthMemberRepository.findByOauthId(oauthMember.oauthId())
//                .orElseGet(() -> oauthMemberRepository.save(oauthMember));
//        return saved.id();
//    }
    public OauthMember login(OauthServerType oauthServerType, String authCode) {  // 수정된 부분
        OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType, authCode);
        return oauthMemberRepository.findByOauthId(oauthMember.oauthId())
                .orElseGet(() -> oauthMemberRepository.save(oauthMember));
    }

}
