package com.interview.banking.onlineBankingService.base.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

import static com.interview.banking.onlineBankingService.base.exceptions.BankingAppException.AppExceptionErrorCode;

//@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private AppExceptionErrorCode errorCode;
	private String errorMessage;
	//private List<ErrorField> fieldErrors;
	private Boolean status = false;
	private String err;
	private String code;
	private HttpStatus httpStatus;

	public ErrorResponse() {
	}

	public AppExceptionErrorCode getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(AppExceptionErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ErrorResponse setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		return this;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getErr() {
		return this.err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
