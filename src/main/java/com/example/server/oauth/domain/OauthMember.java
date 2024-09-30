package com.example.server.oauth.domain;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.PROTECTED;

//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor(access = PROTECTED)
//@Table(name = "oauth_member",
//        uniqueConstraints = {
//                @UniqueConstraint(
//                        name = "oauth_id_unique",
//                        columnNames = {
//                                "oauth_server_id",
//                                "oauth_server"
//                        }
//                ),
//        }
//)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Document(collection = "user")
public class OauthMember {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

//    @Embedded
    private OauthId oauthId;
    private String nickname;
    private String profileImageUrl;

    public String id() {
        return id;
    }

    public OauthId oauthId() {
        return oauthId;
    }

    public String nickname() {
        return nickname;
    }

    public String profileImageUrl() {
        return profileImageUrl;
    }
}
