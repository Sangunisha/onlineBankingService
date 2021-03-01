package com.interview.banking.onlineBankingService.account.controller;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountsResponseDTO;
import com.interview.banking.onlineBankingService.account.service.AccountManagementService;
import com.interview.banking.onlineBankingService.base.exceptions.BankingAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountManagementService accountManagementService;

    private Boolean isAuthorized(String customerId) {
        /*String loggedInCustomerId = "4028abfa77df99680177df9984230000";
        UserRoleEnum loggedInCustomerRole = UserRoleEnum.CUSTOMER;
        if (loggedInCustomerRole.equals(UserRoleEnum.CUSTOMER) && !loggedInCustomerId.equals(customerId)) {
            return false;
        }*/
        return true;
    }

    @GetMapping("/accounts/{customerId}")
    public AccountsResponseDTO getAccounts(@PathVariable("customerId") String customerId) {
        if (!isAuthorized(customerId)) {
            throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_permitted, "You are not permitted to do this action");
        }
        return accountManagementService.getAccounts(customerId);
    }

    @GetMapping("/account/{accountId}")
    public AccountDTO getAccountDetails(@PathVariable("accountId") String accountId) {
        return accountManagementService.getAccountDetails(accountId);
    }

    @GetMapping("/getAccount/{accountNumber}")
    public AccountDTO getAccountDetailsByNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountManagementService.getAccountDetailsByNumber(accountNumber);
    }

    @PostMapping("/account")
    public AccountDTO createAccount(@RequestBody AccountDTO account) {
        return accountManagementService.createAccount(account);
    }

    @DeleteMapping("/account/{accountId}")
    public Boolean deleteAccount(@PathVariable("accountId") String accountId) {
        return accountManagementService.deleteAccount(accountId);
    }
}
