package com.alexGarcia.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alexGarcia.app.dto.UserRegisterDTO;
import com.alexGarcia.app.service.UserService;

@Controller
@RequestMapping("user/signin")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegisterDTO returnNewUserRegisterDTO() {
		return new UserRegisterDTO();
	}
	
	@GetMapping
	public ResponseEntity showRegisterForm() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@PostMapping
	public ResponseEntity signIn(@RequestBody UserRegisterDTO registerDTO) {
		if(userService.save(registerDTO)==null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User alredy exists");
		return ResponseEntity.status(HttpStatus.OK).body("Correct register");
	}
	
}
