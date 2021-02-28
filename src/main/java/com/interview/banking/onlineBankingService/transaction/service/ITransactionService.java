package com.interview.banking.onlineBankingService.transaction.service;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountStatementRequestDTO;
import com.interview.banking.onlineBankingService.account.dto.PaginatedAccountStatementResponseDTO;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferRequestDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionRequestDTO;

public interface ITransactionService {

    AccountDTO createAccount(AccountDTO accountDTO);

    Boolean deleteAccount(String accountId);

    Object doTransaction(String accountId, TransactionRequestDTO transactionRequestDTO);

    Object fundTransfer(FundTransferRequestDTO fundTransferRequestDTO);

    PaginatedAccountStatementResponseDTO getAccountStatement(String accountId, AccountStatementRequestDTO requestDTO);
}
