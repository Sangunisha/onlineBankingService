package com.interview.banking.onlineBankingService.base.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorisedException extends RuntimeException {
    private ErrorResponse errorResponse;

    public UnauthorisedException(String message) {
        super(message);

        errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(message);
        errorResponse.setHttpStatus(HttpStatus.UNAUTHORIZED);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public UnauthorisedException setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        return this;
    }
}

