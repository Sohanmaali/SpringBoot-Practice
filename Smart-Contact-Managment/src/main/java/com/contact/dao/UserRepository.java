package com.contact.dao;

import com.contact.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
	// Your custom repository methods can go here if needed

	@Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.password = :password")
	public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query("SELECT u FROM User u WHERE u.userEmail = :email ")
	public User getUserByEmail(@Param("email") String email);

}
