package com.app.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.transactions.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
