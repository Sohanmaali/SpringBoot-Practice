package com.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "Rohan");
		return "about";
	}

	@GetMapping("/looptry")
	public String iterateHandler(Model model) {
		List<String> list = List.of("sohan", "Mohan", "Rohan", "Rajesh");

		model.addAttribute("list", list);
		;
		return "looptry";
	}

	@GetMapping("/condition")
	public String conditionHandler(Model model) {

		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");
		List<Integer> list = List.of();
		model.addAttribute("myList", list);
		return "condition";
	}

	@GetMapping("/service")
	public String serviceHandler(Model model) {

		return "service";
	}

	@GetMapping("/newAbout")
	public String newAbout(Model model) {

		return "newAbout";
	}
	@GetMapping("/myform")
	public String form(Model model) {
		
		return "form";
	}
}
