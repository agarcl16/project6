package com.alexGarcia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alexGarcia.app.dto.UserLog;
import com.alexGarcia.app.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UserLog userLog) {
		if(userService.login(userLog)==null)return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The user must be registered");
		return ResponseEntity.status(HttpStatus.OK).body("Logged Succesfully");
	}
}
