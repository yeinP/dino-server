package com.example.server.log.service;

import com.example.server.log.dto.UserDto;

public interface LogService {
    UserDto registerUser(UserDto userDto);
}
