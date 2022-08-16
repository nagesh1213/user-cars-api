package com.users.cars.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	private static final int PAGE_SIZE = 10;

	private static final String DESC = "DESC";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarsRepository carsRepository;

	@Override
	public List<User> fetchAllUsers(String lookupString, String sortOrder, int pageNo) {
		log.info("Inside service fetch all users....");
		String order = sortOrder.split(":")[1];
		String sortByField = sortOrder.split(":")[0];
		Pageable pageable = PageRequest.of(pageNo - 1, PAGE_SIZE,
				DESC.equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC, sortByField);
		if (!ObjectUtils.isEmpty(lookupString)) {
			return userRepository.findByLookupString(lookupString, pageable).getContent();
		}
		return userRepository.findAll(pageable).getContent();
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
	public List<Car> fetchAllCars(String lookupString, String sortOrder, int pageNo) {
		log.info("Inside service fetch all cars....");
		String order = sortOrder.split(":")[1];
		String sortByField = sortOrder.split(":")[0];
		Pageable pageable = PageRequest.of(pageNo - 1, PAGE_SIZE,
				DESC.equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC, sortByField);
		if (!ObjectUtils.isEmpty(lookupString)) {
			return carsRepository.findByLookupString(lookupString, pageable).getContent();
		}
		return carsRepository.findAll(pageable).getContent();
	}

	@Override
	public Optional<Car> fetchCarById(Long id) {
		log.info("Inside service fetch car by id....");
		return carsRepository.findById(id);
	}

}
