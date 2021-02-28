package com.interview.banking.onlineBankingService.account.dto;

import com.interview.banking.onlineBankingService.base.constants.TransactionModeEnum;
import com.interview.banking.onlineBankingService.base.constants.TransactionTypeEnum;
import com.interview.banking.onlineBankingService.base.dto.BaseDTO;
import com.interview.banking.onlineBankingService.transaction.dto.TransactionDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


public class AccountStatementDTO extends BaseDTO<AccountStatementDTO> {

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum transactionType;
    @NotNull
    private TransactionModeEnum transactionMode = TransactionModeEnum.ONLINE;
    @NotNull
    private double transactionAmount = 0;
    @NotNull
    private double oldBalanceAmount = 0;
    @NotNull
    private double newBalanceAmount = 0;
    @NotNull
    private TransactionDTO transaction;
    private SavingsAccountDTO account;

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public AccountStatementDTO setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionModeEnum getTransactionMode() {
        return transactionMode;
    }

    public AccountStatementDTO setTransactionMode(TransactionModeEnum transactionMode) {
        this.transactionMode = transactionMode;
        return this;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public AccountStatementDTO setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public double getOldBalanceAmount() {
        return oldBalanceAmount;
    }

    public AccountStatementDTO setOldBalanceAmount(double oldBalanceAmount) {
        this.oldBalanceAmount = oldBalanceAmount;
        return this;
    }

    public double getNewBalanceAmount() {
        return newBalanceAmount;
    }

    public AccountStatementDTO setNewBalanceAmount(double newBalanceAmount) {
        this.newBalanceAmount = newBalanceAmount;
        return this;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public AccountStatementDTO setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
        return this;
    }

    public SavingsAccountDTO getAccount() {
        return account;
    }

    public AccountStatementDTO setAccount(SavingsAccountDTO account) {
        this.account = account;
        return this;
    }
}
