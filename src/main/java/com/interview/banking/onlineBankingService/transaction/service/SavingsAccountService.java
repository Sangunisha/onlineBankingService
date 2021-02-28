package com.interview.banking.onlineBankingService.transaction.service;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountStatementRequestDTO;
import com.interview.banking.onlineBankingService.account.dto.PaginatedAccountStatementResponseDTO;
import com.interview.banking.onlineBankingService.account.dto.SavingsAccountDTO;
import com.interview.banking.onlineBankingService.base.constants.RequestMethodEnum;
import com.interview.banking.onlineBankingService.base.service.ExecutorService;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferDTO;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferRequestDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService implements ITransactionService {

    @Autowired
    private ExecutorService executorService;

    @Value("${banking.savings_account_service}")
    private String SAVINGS_ACCOUNT_SERVICE;

    @Override
    public AccountDTO createAccount(AccountDTO accounDTO) {
        String savingsAccountCreateUrl = SAVINGS_ACCOUNT_SERVICE + "/savingsAccount/create";
        SavingsAccountDTO savingsAccountDTO = populateSavingsAccountDTO(accounDTO);
        savingsAccountDTO = executorService.execute(savingsAccountCreateUrl, RequestMethodEnum.POST, savingsAccountDTO, SavingsAccountDTO.class);
        accounDTO.setTypeSpecificId(savingsAccountDTO.getId());
        accounDTO.setBalanceAmount(savingsAccountDTO.getBalanceAmount());
        return accounDTO;
    }

    private SavingsAccountDTO populateSavingsAccountDTO(AccountDTO accounDTO) {
        return new SavingsAccountDTO()
                .setAccountNumber(accounDTO.getAccountNumber())
                .setBalanceAmount(accounDTO.getBalanceAmount())
                .setBranchId(accounDTO.getBranchId())
                .setCustomerId(accounDTO.getCustomer().getId());
    }

    @Override
    public Boolean deleteAccount(String accountId) {
        String url = SAVINGS_ACCOUNT_SERVICE + "/savingsAccount/" + accountId;
        return executorService.execute(url, RequestMethodEnum.DELETE, Boolean.class);

    }

    public SavingsAccountDTO doTransaction(String accountId, TransactionRequestDTO transactionRequestDTO) {

        String url = SAVINGS_ACCOUNT_SERVICE + "/savingsAccount/transaction/" + accountId;
        SavingsAccountDTO accountsResponseDTO = executorService.execute(url, RequestMethodEnum.PUT, transactionRequestDTO, SavingsAccountDTO.class);
        return accountsResponseDTO;
    }

    @Override
    public Object fundTransfer(FundTransferRequestDTO fundTransferRequestDTO) {
        String url = SAVINGS_ACCOUNT_SERVICE + "/savingsAccount/fundTransfer";
        FundTransferDTO fundTransferDTO = executorService.execute(url, RequestMethodEnum.POST, fundTransferRequestDTO, FundTransferDTO.class);
        return fundTransferDTO;
    }

    @Override
    public PaginatedAccountStatementResponseDTO getAccountStatement(String accountId, AccountStatementRequestDTO requestDTO) {
        String url = SAVINGS_ACCOUNT_SERVICE + "/savingsAccount/statements/" + accountId;
        PaginatedAccountStatementResponseDTO accountStatementResponseDTO = executorService.execute(url, RequestMethodEnum.POST, requestDTO, PaginatedAccountStatementResponseDTO.class);
        return accountStatementResponseDTO;
    }
}
