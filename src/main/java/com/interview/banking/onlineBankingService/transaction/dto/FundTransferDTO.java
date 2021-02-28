package com.interview.banking.onlineBankingService.transaction.dto;

import com.interview.banking.onlineBankingService.account.dto.SavingsAccountDTO;
import com.interview.banking.onlineBankingService.base.constants.FundTransferTypeEnum;
import com.interview.banking.onlineBankingService.base.dto.BaseDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


public class FundTransferDTO extends BaseDTO<FundTransferDTO> {

    @NotNull
    private String customerId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FundTransferTypeEnum fundTransferType;

    @NotNull
    private String comments;
    private String email;
    @NotNull
    private double amount;

    private SavingsAccountDTO fromAccount;

    private SavingsAccountDTO toAccount;

    private TransactionDTO transaction;
    // Future scope
    private String toBeneficiary;

    public String getCustomerId() {
        return customerId;
    }

    public FundTransferDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public FundTransferTypeEnum getFundTransferType() {
        return fundTransferType;
    }

    public FundTransferDTO setFundTransferType(FundTransferTypeEnum fundTransferType) {
        this.fundTransferType = fundTransferType;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public FundTransferDTO setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FundTransferDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public FundTransferDTO setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public SavingsAccountDTO getFromAccount() {
        return fromAccount;
    }

    public FundTransferDTO setFromAccount(SavingsAccountDTO fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public SavingsAccountDTO getToAccount() {
        return toAccount;
    }

    public FundTransferDTO setToAccount(SavingsAccountDTO toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public FundTransferDTO setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
        return this;
    }

    public String getToBeneficiary() {
        return toBeneficiary;
    }

    public FundTransferDTO setToBeneficiary(String toBeneficiary) {
        this.toBeneficiary = toBeneficiary;
        return this;
    }
}
