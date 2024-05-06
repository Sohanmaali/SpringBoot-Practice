package com.contact.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "User Name cannot be empty")
	@Size(min = 3, max = 10, message = "User Name must be between 3 and 10 characters")
	private String userName;

	@Column(unique = true)
	@NotBlank(message = "Email must be provided")
//	@Size(min = 3, max = 100, message = "Email must be between 3 and 100 characters")
//	@Email(message = "Invalid email format")
	private String userEmail;

	@NotBlank(message = "Password must be required !")
	private String password;

	private String role;

	private boolean userEnabled;

	private String userImage;
	@Column(length = 500)

	private String userAbout;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Contact> contacts = new ArrayList<>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userEmail, String password, String role, boolean userEnabled, String userImage,
			String userAbout) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
		this.userEnabled = userEnabled;
		this.userImage = userImage;
		this.userAbout = userAbout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", password=" + password
				+ ", role=" + role + ", userEnabled=" + userEnabled + ", userImage=" + userImage + ", userAbout="
				+ userAbout + ", contacts=" + contacts + "]";
	}

}
