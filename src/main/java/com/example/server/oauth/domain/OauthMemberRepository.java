package com.example.server.oauth.domain;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OauthMemberRepository extends MongoRepository<OauthMember, String> {
    Optional<OauthMember> findByOauthId(OauthId oauthId);
}
