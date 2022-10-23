package com.app.transactions.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.app.transactions.model.User;
import com.app.transactions.repository.UserRepository;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		String credentialsEncoded = request.getHeader("Authorization").substring("Basic".length()).trim();
		String username = new String(Base64.getDecoder().decode(credentialsEncoded), StandardCharsets.UTF_8).split(":")[0]; 
		User user =  repository.findByUsername(username);
		if(user != null) {
			if(user.getAccountlocked() != null && user.getAccountlocked() == true) {
				response.addHeader("Locked", "true");
				response.getOutputStream().println("User account is locked, contact admin");
				response.flushBuffer();
			}
			else {
				user.setFailedattempt(user.getFailedattempt() != null ?  user.getFailedattempt()+ 1: 1);
				if(user.getFailedattempt().equals(3)) {
					user.setAccountlocked(true);
				}
				response.getOutputStream().println("Login failed");
				repository.save(user);
			}
		}
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
	
}
