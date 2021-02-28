package com.interview.banking.onlineBankingService.transaction.dto;

import com.interview.banking.onlineBankingService.base.constants.FundTransferTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


public class FundTransferRequestDTO {

    @NotNull
    @Enumerated(EnumType.STRING)
    private FundTransferTypeEnum fundTransferType;

    @NotNull
    private String comments;
    private String email;
    @NotNull
    private double amount;

    @NotNull
    private String fromAccount;

    @NotNull
    private String toAccount;
    // Future scope
    private String toBeneficiary;
    private String customerId;


    public FundTransferTypeEnum getFundTransferType() {
        return fundTransferType;
    }

    public FundTransferRequestDTO setFundTransferType(FundTransferTypeEnum fundTransferType) {
        this.fundTransferType = fundTransferType;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public FundTransferRequestDTO setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FundTransferRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public FundTransferRequestDTO setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public FundTransferRequestDTO setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public String getToAccount() {
        return toAccount;
    }

    public FundTransferRequestDTO setToAccount(String toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public String getToBeneficiary() {
        return toBeneficiary;
    }

    public FundTransferRequestDTO setToBeneficiary(String toBeneficiary) {
        this.toBeneficiary = toBeneficiary;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public FundTransferRequestDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
}
