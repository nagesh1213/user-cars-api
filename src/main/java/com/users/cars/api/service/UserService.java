package com.users.cars.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.users.cars.api.domain.Car;
import com.users.cars.api.domain.User;
import com.users.cars.api.repository.CarsRepository;
import com.users.cars.api.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarsRepository carsRepository;

	@Override
	public List<User> fetchAllUsers(String lookupString, String sortOrder) {
		log.info("Inside service fetch all users....");
		if (!ObjectUtils.isEmpty(lookupString) && !ObjectUtils.isEmpty(sortOrder)
				&& "ASC".equalsIgnoreCase(sortOrder)) {
			return userRepository.findByNameContainingIgnoreCase(lookupString).stream()
					.sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(lookupString) && !ObjectUtils.isEmpty(sortOrder)
				&& "DESC".equalsIgnoreCase(sortOrder)) {
			return userRepository.findByNameContainingIgnoreCase(lookupString).stream()
					.sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(lookupString)) {
			return userRepository.findByNameContainingIgnoreCase(lookupString).stream().collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(sortOrder) && "DESC".equalsIgnoreCase(sortOrder)) {
			return userRepository.findAll().stream().sorted(Comparator.comparing(User::getName).reversed())
					.collect(Collectors.toList());
		}
		return userRepository.findAll();
	}

	@Override
	public Optional<User> fetchUserById(Long id) {
		log.info("Inside service fetch user by id....");
		return userRepository.findById(id);
	}

	@Override
	public List<Car> fetchCarsByUserId(Long id) {
		log.info("Inside service fetch cars by user id....");
		return carsRepository.findByUser(new User(id));
	}

	@Override
	public List<Car> fetchAllCars(String lookupString, String sortOrder) {
		log.info("Inside service fetch all cars....");
		if (!ObjectUtils.isEmpty(lookupString) && !ObjectUtils.isEmpty(sortOrder)
				&& "ASC".equalsIgnoreCase(sortOrder)) {
			return carsRepository.findByMakeContainingIgnoreCase(lookupString).stream()
					.sorted(Comparator.comparing(Car::getMake)).collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(lookupString) && !ObjectUtils.isEmpty(sortOrder)
				&& "DESC".equalsIgnoreCase(sortOrder)) {
			return carsRepository.findByMakeContainingIgnoreCase(lookupString).stream()
					.sorted(Comparator.comparing(Car::getMake).reversed()).collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(lookupString)) {
			return carsRepository.findByMakeContainingIgnoreCase(lookupString).stream().collect(Collectors.toList());
		} else if (!ObjectUtils.isEmpty(sortOrder) && "DESC".equalsIgnoreCase(sortOrder)) {
			return carsRepository.findAll().stream().sorted(Comparator.comparing(Car::getMake).reversed())
					.collect(Collectors.toList());
		}
		return carsRepository.findAll();
	}

	@Override
	public Optional<Car> fetchCarById(Long id) {
		log.info("Inside service fetch car by id....");
		return carsRepository.findById(id);
	}

}
