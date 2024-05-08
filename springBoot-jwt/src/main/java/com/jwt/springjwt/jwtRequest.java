package com.jwt.springjwt;

public class jwtRequest {

	String username;
	String password;

	public jwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public jwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
