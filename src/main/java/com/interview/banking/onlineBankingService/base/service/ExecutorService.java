package com.interview.banking.onlineBankingService.base.service;

import com.interview.banking.onlineBankingService.base.constants.RequestMethodEnum;
import com.interview.banking.onlineBankingService.base.exceptions.BankingAppException;
import com.interview.banking.onlineBankingService.base.exceptions.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Central Service to execute microservices apis
 */
@Service
public class ExecutorService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @param url
     * @param requestMethod
     * @param request
     * @param responseClass
     * @param <U>
     * @param <T>
     * @return
     */
    public <U, T> T execute(String url, RequestMethodEnum requestMethod, U request, Class<T> responseClass) {
        HttpEntity<U> requestEntity = new HttpEntity<>(request);
        ResponseEntity<T> responseEntity = null;
        T response = null;
        logger.info("Microservice url : "+url);
        switch (requestMethod) {
            case GET:
                response = restTemplate.getForObject(url, responseClass);
                break;
            case PUT:
                responseEntity = restTemplate
                        .exchange(url, HttpMethod.PUT, requestEntity, responseClass);
                response = responseEntity.getBody();
                break;
            case POST:
                response = restTemplate.postForObject(url, request, responseClass);
                break;
            case DELETE:
                responseEntity = restTemplate
                        .exchange(url, HttpMethod.PUT, requestEntity, responseClass);
                response = responseEntity.getBody();
                break;
        }
        if (null != response && response instanceof ErrorResponse) {
            ErrorResponse errorResponse = (ErrorResponse) response;
            throw new BankingAppException(errorResponse.getErrorCode(), errorResponse.getErrorMessage());
        }
        return response;
    }

    public <T> T execute(String url, RequestMethodEnum requestMethod, Class<T> responseDTOClass) {
        return execute(url, requestMethod, null, responseDTOClass);
    }
}
