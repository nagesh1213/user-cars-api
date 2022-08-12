package com.users.cars.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.cars.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameContainingIgnoreCase(String lookupString);

}
