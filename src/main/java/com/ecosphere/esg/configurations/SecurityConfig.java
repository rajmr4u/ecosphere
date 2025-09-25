package com.ecosphere.esg.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	private static final Logger logger = LogManager.getLogger(SecurityConfig.class);

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		logger.debug("In Security Filter chain.....");
		/*
		 * http .csrf(csrf -> csrf.disable()) .authorizeHttpRequests(auth -> auth
		 * .requestMatchers("/public/**").permitAll()
		 * .requestMatchers("/admin/**").hasRole("ADMIN") .anyRequest().authenticated()
		 * ) .formLogin(form -> form.permitAll()) .logout(logout -> logout.permitAll());
		 * 
		 */
		/*
		 * http.csrf().disable() // optional: disable CSRF .authorizeHttpRequests(auth
		 * -> auth.anyRequest().permitAll());
		 */
		http.csrf().disable() // optional: disable CSRF 
		.cors(cors -> {})
		.authorizeHttpRequests(auth
		-> auth.anyRequest().permitAll());
		
		logger.debug("Http Builder ....." );

		return http.build();
	}
}
