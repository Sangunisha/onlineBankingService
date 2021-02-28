package com.interview.banking.onlineBankingService.transaction.controller;

import com.interview.banking.onlineBankingService.account.dto.AccountStatementRequestDTO;
import com.interview.banking.onlineBankingService.account.dto.PaginatedAccountStatementResponseDTO;
import com.interview.banking.onlineBankingService.customer.dto.SpringSecurityPrincipal;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferRequestDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionRequestDTO;
import com.interview.banking.onlineBankingService.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/transaction/{accountId}")
    public Object doTransaction(@PathVariable("accountId") String accountId, @RequestBody TransactionRequestDTO transactionRequestDTO) {
        transactionRequestDTO.setCustomerId(getCurrentCustomerId());
        return transactionService.doTransaction(accountId, transactionRequestDTO);
    }

    @PostMapping("/fundTransfer")
    public Object doTransaction(@RequestBody FundTransferRequestDTO fundTransferRequestDTO) {
        fundTransferRequestDTO.setCustomerId(getCurrentCustomerId());
        return transactionService.transferFund(fundTransferRequestDTO);
    }

    @PostMapping("/statements/{accountId}")
    public PaginatedAccountStatementResponseDTO getAccountStatements(@PathVariable("accountId") String accountId,
                                                                     @RequestBody AccountStatementRequestDTO requestDTO) {
        return transactionService.getAccountStatements(accountId, requestDTO);
    }

    private String getCurrentCustomerId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SpringSecurityPrincipal principal = (SpringSecurityPrincipal) authentication.getPrincipal();
        return principal.getCustomerId();
    }
}
