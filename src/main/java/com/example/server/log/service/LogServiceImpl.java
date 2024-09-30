package com.example.server.log.service;

import com.example.server.log.dto.UserDto;
import com.example.server.log.entity.User;
import com.example.server.log.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto registerUser(UserDto userDto) {
        // Encode the password before saving it
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = User.builder()
                .userId(userDto.getUserId())
                .password(encodedPassword)
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .nickName(userDto.getNickName())
                .birth(userDto.getBirth())
                .build();

        user = userRepository.save(user);
        return UserDto.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword()) // The password should not be exposed in the DTO.
                .email(user.getEmail())
                .phone(user.getPhone())
                .nickName(user.getNickName())
                .birth(user.getBirth())
                .build();
    }

}
