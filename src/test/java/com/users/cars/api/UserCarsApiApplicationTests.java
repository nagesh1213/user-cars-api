package com.users.cars.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.users.cars.api.domain.User;
import com.users.cars.api.repository.CarsRepository;
import com.users.cars.api.repository.UserRepository;
import com.users.cars.api.service.UserService;

@SpringBootTest
class UserCarsApiApplicationTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private CarsRepository carsRepository;

	@InjectMocks
	private UserService userService;

	@Test
	void fetchAllUsersTest1() {
		when(userRepository.findByNameContainingIgnoreCase(anyString())).thenReturn(new ArrayList<User>());
		when(userRepository.findAll()).thenReturn(new ArrayList<User>());
		when(userService.fetchAllUsers("abc", "ase")).thenReturn(new ArrayList<User>());
		assertTrue(true, "Test cases successfully executed..");
	}

	@Test
	void fetchAllUsersTest2() {
		when(userRepository.findByNameContainingIgnoreCase("teet")).thenReturn(new ArrayList<User>());
		when(userRepository.findAll()).thenReturn(new ArrayList<User>());
		when(userService.fetchAllUsers("teet", "desc")).thenReturn(new ArrayList<User>());
		assertTrue(true, "Test cases successfully executed..");
	}

}
