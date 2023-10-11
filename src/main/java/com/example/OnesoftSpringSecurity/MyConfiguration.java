package com.example.OnesoftSpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
public class MyConfiguration extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Gnanasekar").password("$2a$12$6ZpN3kDp3SIGBnU17IKFFOiq4MUfuAgiKUyE73wQJBIQ/mwMiOsMG").roles("get");
//	}
////	@Bean
////	public PasswordEncoder getPass() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//	@Bean
//	public PasswordEncoder getPassword() {
//		return new BCryptPasswordEncoder(12);
//	}
	
	//Access particular end point access particular person ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Gnanasekar").password("$2a$12$6ZpN3kDp3SIGBnU17IKFFOiq4MUfuAgiKUyE73wQJBIQ/mwMiOsMG").roles("student").and().withUser("mani").password("$2a$12$zo5of6dxXjWzoNZFoz5WJutoa0q.Zixf0xmIMoHhm6wUNiIXrxpvK"
				+ "").roles("trainer").and().withUser("arun").password("$2a$12$iey7nGMhRy3yevD6VhyMBepBX/uCjmYD9XR8UZWalnVTOchWvpPR.").roles("manager");
	}
	@Bean
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder(12);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/manager").hasRole("manager");
		http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
		http.authorizeRequests().antMatchers("/student").permitAll().and().formLogin();
		
		
	}

}
