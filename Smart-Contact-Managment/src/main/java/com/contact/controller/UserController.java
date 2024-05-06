package com.contact.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contact.dao.ContactRepository;
import com.contact.dao.UserRepository;
import com.contact.entities.Contact;
import com.contact.entities.User;
import com.contact.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String s = principal.getName();
		User user = this.userRepository.getUserByEmail(s);
		model.addAttribute("user", user);
	}

	@GetMapping("/userDashboard")
	public String loginDataHandler() {
		return "user/userDashboard";
	}

	@GetMapping("/addContact")
	public String addContact(Model model) {

		model.addAttribute("titel", "Add Contect Form");

		model.addAttribute("contact", new Contact());
		return "user/addContact";
	}

	@PostMapping("/saveContact")
	public String saveContactHandler(@ModelAttribute("contact") @Valid Contact contact, BindingResult bindingResult,
			Model model, Principal principal, HttpSession session) {

		try {

			model.addAttribute("titel", "Add Contect Form");

			if (bindingResult.hasErrors()) {
				model.addAttribute("contact", contact);
				return "/user/addContact";
			}

			User user = this.userRepository.getUserByEmail(principal.getName());

			contact.setUser(user);
			user.getContacts().add(contact);

			this.contactRepository.save(contact);

			model.addAttribute("contact", contact);

			session.setAttribute("message", new Message("Success Registered !! ", "alert-success"));
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("contact", contact);
			session.setAttribute("message", new Message("Something went Wrong", "alert-error"));
			return "redirect:/user/contactList/0";
		}
		return "redirect:/user/contactList/0";
	}

	@GetMapping("/contactList/{page}")
	public String contactListHandler(@PathVariable("page") Integer page, Principal principal, Model model) {
		String name = principal.getName();

		PageRequest pageable = PageRequest.of(page, 5);
		User user = this.userRepository.getUserByEmail(name);
		Page<Contact> contacts = this.contactRepository.getAllContactById(user.getId(), pageable);

		model.addAttribute("contacts", contacts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", contacts.getTotalPages());
		return "user/contactList";

	}

	@GetMapping("/editContact/{id}")
	public String editContactHandler(@PathVariable("id") int id, Model model) {
		Contact contact = contactRepository.findById(id).get();

		model.addAttribute("contact", contact);
		return "user/editContact";
	}

	@PostMapping("/updateContactData")
	public String updateContactHandler(@ModelAttribute Contact contact, Principal principal, Model model) {
		try {

			contact.setUser(this.userRepository.getUserByEmail(principal.getName()));
			this.contactRepository.save(contact);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/user/contactList/0";
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContactHandler(@PathVariable("id") int id, Principal principal, Model model) {

		// Delete the contact with the specified ID

		Optional<Contact> opContact = this.contactRepository.findById(id);

		User user = this.userRepository.getUserByEmail(principal.getName());

		Contact contact = opContact.get();
		if (user.getId() == contact.getUser().getId()) {
//			contact.setUser(null);
			this.contactRepository.delete(contact);
		}

		return "redirect:/user/contactList/0";
	}

	@GetMapping("/profile")
	public String profile() {
		return "/user/profile";
	}
}
