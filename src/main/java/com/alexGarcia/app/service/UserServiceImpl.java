package com.alexGarcia.app.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alexGarcia.app.dto.UserLog;
import com.alexGarcia.app.dto.UserRegisterDTO;
import com.alexGarcia.app.entity.Rol;
import com.alexGarcia.app.entity.User;
import com.alexGarcia.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegisterDTO registerDTO) {
		User user = new User(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getUserName(), registerDTO.getPassword());
		
		if(userRepository.findByUserName(registerDTO.getUserName())==null) {
			return userRepository.save(user);
		}
		return null;		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid user or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapAuthorityRoles(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapAuthorityRoles(Collection<Rol> roles){
		return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User login(UserLog userLog) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserName(userLog.getUserName());
		if(user==null||!user.getPassword().equals(userLog.getPassword()))return null;
		return user;
	}
}
