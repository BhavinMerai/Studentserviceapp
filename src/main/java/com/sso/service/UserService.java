package com.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sso.entity.User;
import com.sso.entity.Roles;
import com.sso.repository.RolesRepository;
import com.sso.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository professorRepository;

	@Autowired
	RolesRepository roleRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public void registerDefaultUser(User professor) {
		
		Roles roleUser = roleRepo.findByName("PROFFESOR");
		professor.addRole(roleUser);
		professor.setPassword(passwordEncoder.encode(professor.getPassword()));
		professorRepository.save(professor);
	}
	
	public User getProfessorByName(String email) {
		
		return professorRepository.findByEmail(email);
	}

}