package com.cato.core.billing.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.cato.core.billing.common.service.EBillUserDetailService;

@Configuration
@EnableWebSecurity
public class EBillSecurityConfig {

	@Autowired
	private EBillUserDetailService userDetailService;
	
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin(Login -> Login.permitAll())
		.logout(logout -> logout.permitAll());
		return http.build();
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("Pranav").password("{noop}pass").roles
	 * ("admin");
	 * 
	 * }
	 */
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailService);

	}
}
