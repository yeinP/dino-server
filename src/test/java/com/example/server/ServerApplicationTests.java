package com.example.server;

import com.example.server.log.dto.UserDto;
import com.example.server.log.entity.User;
import com.example.server.log.repository.UserRepository;
import com.example.server.log.service.LogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@InjectMocks
	private LogServiceImpl logService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testRegisterUser() {
		// Given
		UserDto userDto = UserDto.builder()
				.userId("testUser")
				.password("password123")
				.email("test@example.com")
				.phone("1234567890")
				.nickName("TestUser")
				.birth("19900101")
				.build();

		User user = User.builder()
				.id("12345")
				.userId("testUser")
				.password(passwordEncoder.encode("password123"))
				.email("test@example.com")
				.phone("1234567890")
				.nickName("TestUser")
				.birth("19900101")
				.build();

		// Mocking the userRepository.save method
		when(userRepository.save(user)).thenReturn(user);

		// When
		UserDto result = logService.registerUser(userDto);

		// Then
		assertEquals(userDto.getUserId(), result.getUserId());
		assertEquals(userDto.getEmail(), result.getEmail());
		assertEquals(userDto.getPhone(), result.getPhone());
		assertEquals(userDto.getNickName(), result.getNickName());
		assertEquals(userDto.getBirth(), result.getBirth());
	}
}
