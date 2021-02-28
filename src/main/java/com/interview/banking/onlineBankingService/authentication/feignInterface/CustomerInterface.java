package com.interview.banking.onlineBankingService.authentication.feignInterface;

import com.interview.banking.onlineBankingService.authentication.constants.MicroServiceConstants;
import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.interview.banking.onlineBankingService.authentication.constants.MicroServiceConstants.CUSTOMER_MICROSERVICE;

@FeignClient(name = CUSTOMER_MICROSERVICE)
@Service
public interface CustomerInterface {

    @RequestMapping(value = MicroServiceConstants.AdminMicroServiceConstants.FETCH_USER_BY_USERNAME)
    Optional<CustomerDTO> fetchUserByUsername(@PathVariable("username") String username);

}
