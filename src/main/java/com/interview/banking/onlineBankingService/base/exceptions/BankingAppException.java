package com.interview.banking.onlineBankingService.base.exceptions;

public class BankingAppException extends RuntimeException
{

	private static final long serialVersionUID = -7374201234165750605L;

	public enum AppExceptionErrorCode{
		user_exists,
		invalid_data,
		user_does_not_exist,
		invalid_password,
		password_missing,
		object_does_not_exist,
		bad_request_error,
		parameter_missing,
		not_authorized,
		internal_server_error,
		invalid_state,
		validation_errors,
		stale_object_found,
		api_exception,
		operation_failed_exception,
		invalid_request_exception,
        not_available,
        not_permitted,
		phone_verification_required,
		username_password_mismatch,
		user_disabled,
		too_many_requests,
		not_a_valid_mobile_phone_number,
		not_implemented
	}
	
	protected AppExceptionErrorCode errorCode;

    protected String messageKey;
	
	public BankingAppException(){}
	
	public BankingAppException(String message){
		super(message);
	}

	public BankingAppException(AppExceptionErrorCode errorCode){
		this.errorCode = errorCode;
	}

	public BankingAppException(AppExceptionErrorCode errorCode, String logMessage){
		super(logMessage);
		this.errorCode = errorCode;
	}

    public BankingAppException(AppExceptionErrorCode errorCode, String messageKey, String logMessage){
        super(logMessage);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

	public BankingAppException(AppExceptionErrorCode errorCode, String messageKey, String logMessage, Throwable cause){
		super(logMessage, cause);
		this.errorCode = errorCode;
        this.messageKey = messageKey;
	}

	public AppExceptionErrorCode getErrorCode() {
		return errorCode;
	}

	public BankingAppException setErrorCode(AppExceptionErrorCode errorCode) {
		this.errorCode = errorCode;
        return this;
	}

    public String getMessageKey() {
        return messageKey;
    }

    public BankingAppException setMessageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }
}
