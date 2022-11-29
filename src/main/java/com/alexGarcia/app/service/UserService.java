package com.alexGarcia.app.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.alexGarcia.app.dto.UserLog;
import com.alexGarcia.app.dto.UserRegisterDTO;
import com.alexGarcia.app.entity.User;

public interface UserService extends UserDetailsService{

		public User save(UserRegisterDTO registerDTO);
		
		public List<User> getUsers();
		
		public User login(UserLog userLog);
	
}
