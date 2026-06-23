package com.example.MatrimonyManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired    
	private JwtAuthEntryPoint jwtAuthEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf -> csrf.disable())
			.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint))
			.authorizeHttpRequests(auth -> auth 
					.requestMatchers("/admin/register",
					        "/customer/register",
					        "/customer/profile/",
					        "/customerprofile/register",
					        "/auth/login/admin","/auth/login/customer","/email/send",
					        "/email/verify-email-otp",
					        "/religion/register",
					        "/caste/register","/state/register","/district/register","/taluka/register","/village/register",
					        "/subcaste/register",
					        "/password-reset"
					        ,"/biodata/download").permitAll()
					.anyRequest().authenticated()
					)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			);
	
		 http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

			
		    return http.build();
	}

}
