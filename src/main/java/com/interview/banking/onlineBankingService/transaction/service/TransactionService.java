package com.interview.banking.onlineBankingService.transaction.service;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountStatementRequestDTO;
import com.interview.banking.onlineBankingService.account.dto.PaginatedAccountStatementResponseDTO;
import com.interview.banking.onlineBankingService.account.service.AccountManagementService;
import com.interview.banking.onlineBankingService.base.constants.AccountTypeEnum;
import com.interview.banking.onlineBankingService.base.constants.TransactionTypeEnum;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferRequestDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private AccountManagementService accountManagementService;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @Autowired
    private LoanAccountService loanAccountService;

    public ITransactionService getAccountService(AccountTypeEnum accountType) {
        switch (accountType) {
            case SAVINGS:
                return savingsAccountService;
            case LOAN:
                return loanAccountService;
        }
        return null;
    }

    public Object doTransaction(String accountId, TransactionRequestDTO transactionRequestDTO) {
        AccountDTO accountDTO = accountManagementService.getAccountDetails(accountId);
        Object response = getAccountService(accountDTO.getAccountType()).doTransaction(accountDTO.getTypeSpecificId(), transactionRequestDTO);
        updateBaseAccount(accountDTO, transactionRequestDTO.getTransactionType(), transactionRequestDTO.getAmount());
        return response;
    }

    private void updateBaseAccount(AccountDTO accountDTO, TransactionTypeEnum transactionType, double amount) {
        double newAmount = accountDTO.getBalanceAmount();
        switch (transactionType) {
            case CREDIT:
                newAmount += amount;
                break;
            case DEBIT:
                newAmount -= amount;
        }
        accountDTO.setBalanceAmount(newAmount);
        accountManagementService.updateAccountBalance(accountDTO);
    }

    public Object transferFund(FundTransferRequestDTO fundTransferRequestDTO) {
        //AccountDTO fromAccountDTO = accountManagementService.getAccountDetails(fundTransferRequestDTO.getFromAccount());
        AccountDTO fromAccountDTO = accountManagementService.getAccountDetailsByNumber(fundTransferRequestDTO.getFromAccount());

        fundTransferRequestDTO.setFromAccount(fromAccountDTO.getTypeSpecificId());
        AccountDTO toAccountDTO = accountManagementService.getAccountDetailsByNumber(fundTransferRequestDTO.getToAccount());
        fundTransferRequestDTO.setToAccount(toAccountDTO.getTypeSpecificId());
        Object response = getAccountService(fromAccountDTO.getAccountType()).fundTransfer(fundTransferRequestDTO);
        updateBaseAccount(fromAccountDTO, TransactionTypeEnum.DEBIT, fundTransferRequestDTO.getAmount());
        updateBaseAccount(toAccountDTO, TransactionTypeEnum.CREDIT, fundTransferRequestDTO.getAmount());
        return response;
    }

    public PaginatedAccountStatementResponseDTO getAccountStatements(String accountId, AccountStatementRequestDTO requestDTO) {
        AccountDTO accountDTO = accountManagementService.getAccountDetails(accountId);
        requestDTO.setAccountId(accountDTO.getTypeSpecificId());
        PaginatedAccountStatementResponseDTO statementResponseDTO = getAccountService(accountDTO.getAccountType())
                .getAccountStatement(accountDTO.getTypeSpecificId(), requestDTO);
        if (null != statementResponseDTO && null != statementResponseDTO) {
            statementResponseDTO.getAccount().setId(accountDTO.getId());
        }
        return statementResponseDTO;
    }
}
