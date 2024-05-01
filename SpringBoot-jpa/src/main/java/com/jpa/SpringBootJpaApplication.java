package com.jpa;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entitais.User;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		// Save one user
//		User user = new User();
//		user.setName("Sohan");
//		user.setCity("amla");
//		User u1 = userRepository.save(user);
//		System.out.println(u);

		// Save multipale user
//		User user = new User();
//		user.setName("mohan");
//		user.setCity("Indore");
//
//		User user1 = new User();
//		user1.setName("rohan");
//		user1.setCity("Indore");
//
//		List<User> u0 = List.of(user, user1);
//		Iterable<User> saveAll = userRepository.saveAll(u0);
//		saveAll.forEach(u -> System.out.println(u));

//		Get Data And Update
//		Optional<User> optional = userRepository.findById(1);
//		User u = optional.get();
//		u.setName("Raj");
//		System.out.println(userRepository.save(u));

		// get All DATA
//		Iterable<User> allUser = userRepository.findAll();
//		allUser.forEach(u -> System.out.println(u));

//		DELETE DATA
//		userRepository.delete( userRepository.findById(103).get());
//		Iterable<User> allUser = userRepository.findAll();
//		allUser.forEach(u -> System.out.println(u));

		// Custome finder Method

		userRepository.getUserByName("sohan").forEach(u -> System.out.println(u));
	}

}
