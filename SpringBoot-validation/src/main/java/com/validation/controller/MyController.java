package com.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entities.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/myform")
	public String myForm(Model model) {
		return "form";
	}

	@PostMapping("/controller")
	public String formDataHandler(@ModelAttribute("loginData") @Valid LoginData loginData, BindingResult bindingResult,
			Model model) {

		System.out.println("called");
		if (bindingResult.hasErrors()) {
			System.out.println("Error: " + bindingResult);
			return "form";
		}
		model.addAttribute("formData", loginData);
		return "success";

	}

}
