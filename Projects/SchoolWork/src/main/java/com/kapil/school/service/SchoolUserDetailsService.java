package com.kapil.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kapil.school.model.SchoolUserDetails;
import com.kapil.school.model.User;
import com.kapil.school.repository.UserRepository;

@Service
public class SchoolUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("! "+username);
		Optional<User> optionalUser = userRepository.findByUserName(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUser.map(SchoolUserDetails::new).get();
	}

}
