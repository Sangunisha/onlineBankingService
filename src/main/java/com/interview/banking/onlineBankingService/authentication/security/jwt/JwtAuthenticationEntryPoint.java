package com.interview.banking.onlineBankingService.authentication.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
						 AuthenticationException authException) throws IOException, ServletException {
		logger.debug("Jwt authentication failed:" + authException);

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED	, "Jwt authentication failed");
	}
}
