package com.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.entitais.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.name = :n")
	public List<User> getUserByName(@Param("n") String name);
	
//	findNameStartingWith(String s);
//	findNameEndingWith(String s);
//	findNameContaining(String s);

}
