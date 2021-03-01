package com.interview.banking.onlineBankingService.customer.service;

import com.interview.banking.onlineBankingService.base.constants.RequestMethodEnum;
import com.interview.banking.onlineBankingService.base.service.ExecutorService;
import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;
import com.interview.banking.onlineBankingService.customer.dto.CustomerSearchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service to manage customer data
 */
@Service
public class CustomerManagementService {
    @Autowired
    private ExecutorService executorService;

    @Value("${banking.customer_service}")
    private String CUSTOMER_SERVICE;

    public CustomerDTO getCustomerDetails(String customerId) {
        String url = CUSTOMER_SERVICE + "/customer/" + customerId;
        CustomerDTO customerDTO = executorService.execute(url, RequestMethodEnum.GET, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerDTO searchCustomer(CustomerSearchRequestDTO searchRequestDTO) {
        String url = CUSTOMER_SERVICE + "/customer/search";
        CustomerDTO customerDTO = executorService.execute(url, RequestMethodEnum.POST, searchRequestDTO, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerDTO createCustomer(CustomerDTO customer) {
        String url = CUSTOMER_SERVICE + "/customer/";
        CustomerDTO customerDTO = executorService.execute(url, RequestMethodEnum.POST, customer, CustomerDTO.class);
        customerDTO.setPassword(null);
        return customerDTO;
    }

    public CustomerDTO updateCustomer(String customerId, CustomerDTO customer) {
        String url = CUSTOMER_SERVICE + "/customer/" + customerId;
        CustomerDTO customerDTO = executorService.execute(url, RequestMethodEnum.PUT, customer, CustomerDTO.class);
        return customerDTO;
    }

    public Boolean deleteCustomer(String customerId) {
        String url = CUSTOMER_SERVICE + "/customer/" + customerId;
        Boolean status = executorService.execute(url, RequestMethodEnum.DELETE, Boolean.class);
        return status;
    }
}
