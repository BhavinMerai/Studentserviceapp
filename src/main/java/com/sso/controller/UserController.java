package com.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sso.entity.User;
import com.sso.service.UserService;

@Controller
public class UserController {

	@Autowired UserService professorRepository;
	
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User professor) {
		
		professorRepository.registerDefaultUser(professor);
		
		return "redirect:/login";
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String home() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/login-error")
	public String loginerror() {
		return "login-error";
	}
	
	@PostMapping("/login-error")
	public String loginerrorpage() {
		return "redirect:/login";
	}
	
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}
	
	@GetMapping("/manage-students")
	@PreAuthorize("hasAuthority('PROFFESOR')")
	public String manage() {
		return "manage-students";
	}
}
