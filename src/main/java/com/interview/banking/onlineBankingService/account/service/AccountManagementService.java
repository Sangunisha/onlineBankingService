package com.interview.banking.onlineBankingService.account.service;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountsResponseDTO;
import com.interview.banking.onlineBankingService.base.constants.RequestMethodEnum;
import com.interview.banking.onlineBankingService.base.service.ExecutorService;
import com.interview.banking.onlineBankingService.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountManagementService {


    @Autowired
    private ExecutorService executorService;
    @Autowired
    private TransactionService transactionService;

    @Value("${banking.customer_service}")
    private String CUSTOMER_SERVICE;

    public AccountsResponseDTO getAccounts(String customerId) {
        String url = CUSTOMER_SERVICE + "/accounts/" + customerId;
        AccountsResponseDTO accountsResponseDTO = executorService.execute(url, RequestMethodEnum.GET, AccountsResponseDTO.class);
        return accountsResponseDTO;
    }

    public AccountDTO getAccountDetails(String accountId) {
        String url = CUSTOMER_SERVICE + "/account/" + accountId;
        AccountDTO accounDTO = executorService.execute(url, RequestMethodEnum.GET, AccountDTO.class);
        return accounDTO;
    }

    public AccountDTO getAccountDetailsByNumber(String accountNumber) {
        String url = CUSTOMER_SERVICE + "/getAccount/" + accountNumber;
        AccountDTO accounDTO = executorService.execute(url, RequestMethodEnum.GET, AccountDTO.class);
        return accounDTO;
    }

    @Transactional
    public AccountDTO createAccount(AccountDTO account) {
        String url = CUSTOMER_SERVICE + "/account";
        AccountDTO accounDTO = executorService.execute(url, RequestMethodEnum.POST, account, AccountDTO.class);
        accounDTO = transactionService.getAccountService(accounDTO.getAccountType()).createAccount(accounDTO);
        return updateAccount(accounDTO);
    }

    private AccountDTO updateAccountId(AccountDTO accounDTO) {
        String url = CUSTOMER_SERVICE + "/accountId/" + accounDTO.getId();
        accounDTO = executorService.execute(url, RequestMethodEnum.PUT, accounDTO, AccountDTO.class);
        return accounDTO;
    }

    private AccountDTO updateAccount(AccountDTO accounDTO) {
        String url = CUSTOMER_SERVICE + "/account/" + accounDTO.getId();
        accounDTO = executorService.execute(url, RequestMethodEnum.PUT, accounDTO, AccountDTO.class);
        return accounDTO;
    }

    public AccountDTO updateAccountBalance(AccountDTO accounDTO) {
        String url = CUSTOMER_SERVICE + "/accountBalance/" + accounDTO.getId();
        accounDTO = executorService.execute(url, RequestMethodEnum.PUT, accounDTO, AccountDTO.class);
        return accounDTO;
    }

    @Transactional
    public Boolean deleteAccount(String accountId) {
        String url = CUSTOMER_SERVICE + "/account/" + accountId;
        AccountDTO accountDTO = executorService.execute(url, RequestMethodEnum.GET, AccountDTO.class);
        Boolean deleteStatus = executorService.execute(url, RequestMethodEnum.DELETE, Boolean.class);
        return transactionService.getAccountService(accountDTO.getAccountType()).deleteAccount(accountDTO.getTypeSpecificId());
    }
}
