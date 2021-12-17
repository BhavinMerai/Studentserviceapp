package com.sso.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/register","/login")
		 .permitAll().antMatchers("/home").authenticated().and().csrf().disable()
		 .formLogin().loginPage("/login")
		 .defaultSuccessUrl("/home")
		 .usernameParameter("email").passwordParameter("password")
		 .failureUrl("/login-error")
		 .and().exceptionHandling().accessDeniedPage("/access-denied")
		 .and().logout().logoutSuccessUrl("/logout").logoutSuccessUrl("/login");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
