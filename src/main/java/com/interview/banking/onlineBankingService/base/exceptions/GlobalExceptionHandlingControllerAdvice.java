package com.interview.banking.onlineBankingService.base.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//Restricting controller advice to 'com.needstreet' to prevent clashes with spring security exceptions. Without this the login form
//does not show - https://stackoverflow.com/questions/43241767/spring-oauth2-authorization-code-grant-impossibile-to-reach-oauth-authorize/43293362#43293362

@ControllerAdvice("com.interview.banking.onlineBankingService")
public class GlobalExceptionHandlingControllerAdvice {

	protected Logger logger;
	
	@Autowired
	private MessageSource messageSource;

	public GlobalExceptionHandlingControllerAdvice() {
		logger = LoggerFactory.getLogger(getClass());
	}

	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BankingAppException.class)
	public @ResponseBody ErrorResponse handleAppError(BankingAppException appException) {
		ErrorResponse errorResponse = new ErrorResponse();
		if (appException.getErrorCode()!=null)
			errorResponse.setErrorCode(appException.getErrorCode());
		errorResponse.setErrorMessage(appException.getMessage());
		logger.debug("AppException", appException);
		return errorResponse;
	}
	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UnauthorisedException.class)
	public @ResponseBody
	ErrorResponse handleAuthError(UnauthorisedException appException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.UNAUTHORIZED);
		errorResponse.setErrorMessage(appException.getMessage());
		logger.debug("AppException", appException);
		return errorResponse;
	}
	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public @ResponseBody
    ErrorResponse handleGeneralError(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(BankingAppException.AppExceptionErrorCode.api_exception);
		errorResponse.setErrorMessage(exception.getMessage());
		logger.debug("General Exception", exception);
		return errorResponse;
	}

}