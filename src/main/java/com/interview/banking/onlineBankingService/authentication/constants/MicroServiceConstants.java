package com.interview.banking.onlineBankingService.authentication.constants;

public class MicroServiceConstants {

    public static final String LOGIN_MICROSERVICE = "/login-service/**";

    public static final String CUSTOMER_MICROSERVICE = "customer-service";
    public static final String BASE_API = "/api";

    public interface AdminMicroServiceConstants {
        String FETCH_USER_BY_USERNAME = "/customer/getUser/{username}";
    }
}
