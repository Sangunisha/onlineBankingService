package com.interview.banking.onlineBankingService.customer.controller;

import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;
import com.interview.banking.onlineBankingService.customer.dto.CustomerSearchRequestDTO;
import com.interview.banking.onlineBankingService.customer.service.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to manage customer data requests
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerManagementService customerManagementService;

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerDetails(@PathVariable("customerId") String customerId) {
        return customerManagementService.getCustomerDetails(customerId);
    }

    @PostMapping("/search")
    public CustomerDTO searchCustomer(@RequestBody CustomerSearchRequestDTO searchRequestDTO) {
        return customerManagementService.searchCustomer(searchRequestDTO);
    }

    @PostMapping("/")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer) {
        return customerManagementService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable("customerId") String customerId, @RequestBody CustomerDTO customer) {
        return customerManagementService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public Boolean deleteCustomer(@PathVariable("customerId") String customerId) {
        return customerManagementService.deleteCustomer(customerId);
    }
}
