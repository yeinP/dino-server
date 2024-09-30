package com.example.server.log.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String userId;
    private String password;

    private String email;
    private String phone;
    private String nickName;
    private String birth;
}


