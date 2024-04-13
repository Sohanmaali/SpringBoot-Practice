package com.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.web.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);

	@Query("select u from User u")
	public List<User> getAllUse();

	@Query("SELECT u FROM User u WHERE u.name = :n")
	public List<User> getUserByName(@Param("n") String name);

}
