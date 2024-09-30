package com.example.server.oauth.domain;

//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

//import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;


@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class OauthId {
    @Field(name = "oauth_server_id")
    private String oauthServerId;


    @Field( name = "oauth_server")
    private OauthServerType oauthServerType;

    public String oauthServerId() {
        return oauthServerId;
    }

    public OauthServerType oauthServer() {
        return oauthServerType;
    }
}
