package com.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.contact.dao.UserRepository;
import com.contact.entities.User;
import com.contact.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("navTitel", "Home-Page of Smart contact managment");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("navTitel", "About-Page of Smart contact managment");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model, HttpSession session) {
		model.addAttribute("navTitel", "Sign Up-Page of Smart contact managment");
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("navTitel", "Login-Page of Smart contact managment");
		model.addAttribute("user", new User());
		System.out.println("Login call");
		return "login";
	}

	@PostMapping("/regisreationData")
	public String regisreationDataHandler(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			@RequestParam(value = "checkbox", defaultValue = "false") boolean checkbox, Model model,
			HttpSession session) {
		try {

			if (!checkbox) {
				throw new Exception("You have not agreed the turm and condition");
			}

			if (bindingResult.hasErrors()) {
				model.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setUserEnabled(true);
			user.setUserImage("default.png");
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

			User result = this.userRepository.save(user);

			model.addAttribute("user", new User());

			session.setAttribute("message", new Message("Success Registered !! ", "alert-success"));
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went Wrong", "alert-error"));
			return "signup";
		}
		return "login";
	}

//	@PostMapping("/loginData")
//	public String loginDataHandler(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
//			@RequestParam(value = "checkbox", defaultValue = "false") Boolean checkbox, Model model) {
//		try {
//
//			if (!checkbox) {
//				throw new Exception("You have not agreed the turm and condition");
//			}
//
//			User u = this.userRepository.findByEmailAndPassword(user.getUserEmail(), user.getUserPassword());
//
//			System.out.println(u);
//		} catch (Exception e) {
//			System.out.println(e);
//			return "/login";
//		}
//
//		return "user/userDashboard";
//	}

}
