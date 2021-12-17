package com.sso.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sso.entity.User;
import com.sso.entity.Roles;
import com.sso.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserService professorService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User professor = professorService.getProfessorByName(email);
		
		if (professor == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		Set<SimpleGrantedAuthority> authorites = new HashSet<>();
		
		for(Roles role : professor.getRoles()) {
			authorites.add(new SimpleGrantedAuthority(role.getName()));
		}
		
     	return	new org.springframework.security.core.userdetails.User(professor.getEmail(),professor.getPassword(),authorites);
	}

	
	
}