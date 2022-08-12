package com.users.cars.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.cars.api.domain.Car;
import com.users.cars.api.domain.User;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

	List<Car> findByUser(User user);

	List<Car> findByMakeContainingIgnoreCase(String lookupString);

}
