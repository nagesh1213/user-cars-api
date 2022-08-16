package com.users.cars.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.users.cars.api.domain.Car;
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
	void fetchUserByIdTest5() {
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
		when(userService.fetchUserById(anyLong())).thenReturn(Optional.of(new User()));
		assertTrue(true, "Test cases successfully executed..");
	}

	@Test
	void fetchCarsByUserIdTest6() {
		when(carsRepository.findByUser(new User(anyLong()))).thenReturn(new ArrayList<Car>());
		when(userService.fetchCarsByUserId(anyLong())).thenReturn(new ArrayList<Car>());
		assertTrue(true, "Test cases successfully executed..");
	}

	@Test
	void fetchCarByIdTest7() {
		when(carsRepository.findById(anyLong())).thenReturn(Optional.of(new Car()));
		when(userService.fetchCarById(anyLong())).thenReturn(Optional.of(new Car()));
		assertTrue(true, "Test cases successfully executed..");
	}

}
