package com.web;

import org.springframework.context.ApplicationContext;

import com.web.dao.UserRepository;
import com.web.entities.User;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);
		System.out.println("Home page");

		UserRepository repository = context.getBean(UserRepository.class);

		// Save One user
		/*
		 * User user = new User(); user.setName("Sohan"); user.setAddress("Indore");
		 * System.out.println(repository.save(user));
		 */

//		Save Multipal User
		/*
		 * User user = new User(); user.setName("Mohan"); user.setAddress("Amla");
		 * 
		 * User user1 = new User(); user1.setName("Rohan"); user1.setAddress("ktg");
		 * 
		 * User user2 = new User(); user2.setName("Ankit"); user2.setAddress("Indore");
		 * 
		 * List<User> users = List.of(user, user1, user2);
		 * 
		 * Iterable<User> resIterable = repository.saveAll(users);
		 * 
		 * resIterable.forEach(us -> { System.out.println(us); });
		 */

//		update Data

		/*
		 * Optional<User> u = repository.findById(1); User s = u.get();
		 * s.setName("Sohan Maali"); System.out.println(repository.save(s));
		 */

//		Get All Data

		/*
		 * Iterable<User> user = repository.findAll(); user.forEach(u ->
		 * System.out.println(u));
		 */

//		Delete Data

		repository.deleteById(4);

		Iterable<User> user = repository.findAll();
		user.forEach(u -> System.out.println(u));
	}
}
