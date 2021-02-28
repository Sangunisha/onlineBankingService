package com.interview.banking.onlineBankingService.transaction.service;

import com.interview.banking.onlineBankingService.account.dto.AccountDTO;
import com.interview.banking.onlineBankingService.account.dto.AccountStatementRequestDTO;
import com.interview.banking.onlineBankingService.account.dto.PaginatedAccountStatementResponseDTO;
import com.interview.banking.onlineBankingService.base.exceptions.BankingAppException;
import com.interview.banking.onlineBankingService.base.service.ExecutorService;
import com.interview.banking.onlineBankingService.transaction.dto.FundTransferRequestDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoanAccountService implements ITransactionService {

    @Autowired
    private ExecutorService executorService;

    @Value("${banking.loan_account_service}")
    private String LOAN_ACCOUNT_SERVICE;

    @Override
    public AccountDTO createAccount(AccountDTO accounDTO) {
        String url = LOAN_ACCOUNT_SERVICE + "/loanAccount/create";
        throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_implemented, "Not Implemented");
    }

    @Override
    public Boolean deleteAccount(String accountId) {
        String url = LOAN_ACCOUNT_SERVICE + "/loanAccount/delete";
        throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_implemented, "Not Implemented");
    }

    @Override
    public Object doTransaction(String accountId, TransactionRequestDTO transactionRequestDTO) {

        String url = LOAN_ACCOUNT_SERVICE + "/loanAccount/transaction/" + accountId;
        throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_implemented, "Not Implemented");
    }

    @Override
    public Object fundTransfer(FundTransferRequestDTO fundTransferRequestDTO) {
        String url = LOAN_ACCOUNT_SERVICE + "/loanAccount/fundTransfer";
        throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_implemented, "Not Implemented");

    }

    @Override
    public PaginatedAccountStatementResponseDTO getAccountStatement(String accountId, AccountStatementRequestDTO requestDTO) {
        String url = LOAN_ACCOUNT_SERVICE + "/loanAccount/statements/" + accountId;
        throw new BankingAppException(BankingAppException.AppExceptionErrorCode.not_implemented, "Not Implemented");

    }
}
