package com.gokdemir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gokdemir.jwt.AuthEntryPoint;
import com.gokdemir.jwt.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	public static final String AUTHENTICATE = "/authenticate";
	public static final String REGISTER = "/register";
	public static final String REFRESH_TOKEN = "/refreshToken";
	
	public static final String[] SWAGGER_PATHS = {
		    "/swagger-ui/**",
		    "/v3/api-docs/**",
		    "/swagger-ui.html"
		};

	
	private final AuthenticationProvider authenticationProvider;
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	private final AuthEntryPoint authEntryPoint;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable() //JWT kullanıldığında, CSRF saldırıları doğrudan etkisiz hale geldiği için genellikle kapatılır.
		.authorizeHttpRequests(request ->
		request.requestMatchers(AUTHENTICATE , REGISTER, REFRESH_TOKEN).permitAll()
		.requestMatchers(SWAGGER_PATHS).permitAll()
		.anyRequest()
		.authenticated())
		.exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}
