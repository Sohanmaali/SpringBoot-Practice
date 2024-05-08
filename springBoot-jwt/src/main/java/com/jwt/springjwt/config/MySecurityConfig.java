package com.jwt.springjwt.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jwt.springjwt.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig implements UserDetailsService {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.equals("Sohan")) {
			return new User("Sohan", "2002", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
//		return null;
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(
						requests -> requests.requestMatchers("/token").permitAll().anyRequest().authenticated())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

}

//@Bean
//UserDetailsService getUserDetailsService() {
//	return new UserDetailServiceImpl();
//}

//@Bean
//DaoAuthenticationProvider authenticationProvider() {
//	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//	authenticationProvider.setUserDetailsService(this.getUserDetailsService());
//	authenticationProvider.setPasswordEncoder(passwordEncoder());
//	return authenticationProvider;
//}
