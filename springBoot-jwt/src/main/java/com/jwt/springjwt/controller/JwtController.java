package com.jwt.springjwt.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springjwt.jwtRequest;

@RestController
public class JwtController {

	@PostMapping("/token")
	public ResponseEntity<?> generateRoken(@RequestBody jwtRequest jwtRequests) {

	}
}
