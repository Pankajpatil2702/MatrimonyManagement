package com.example.MatrimonyManagement.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


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
			.csrf(csrf -> csrf.disable()).cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint))
			.authorizeHttpRequests(auth -> auth 
					.requestMatchers(
							
							"/admins/register",
							"/caste/register",
							"/consultancy/register",
							"/customers/register",
							"/customersprofile/register",
							"/district/register",
							"/plan/register",
							"/profileinterest/register",
							"/religion/register",
							"/state/register",
							"/subcaste/register",
							"/taluka/register",
							"/village/register",
							
							"/auth/admin/login", "/auth/customer/login",
							
							"/auth/verify-email-otp",
							"/auth/password-reset",
							"/auth/customer/mailsend",
							"/auth/admin/mailsend",
							
							"/biodata/download"
					        
					        
					        ).permitAll()
					.anyRequest().authenticated()
					)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			);
	
		 http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

			
		    return http.build();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration =
                new CorsConfiguration();

        configuration.setAllowedOrigins(
                List.of("http://localhost:4200"));

        configuration.setAllowedMethods(
                List.of("GET","POST","PUT","DELETE","OPTIONS"));

        configuration.setAllowedHeaders(
                List.of("*"));

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource	 source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration
        );

        return (CorsConfigurationSource) source;
    }   

}
