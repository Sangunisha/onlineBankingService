package com.interview.banking.onlineBankingService.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.interview.banking.onlineBankingService.base.dto.BaseDTO;
import com.interview.banking.onlineBankingService.base.constants.AccountTypeEnum;
import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO extends BaseDTO<AccountDTO> implements Serializable {

    @NotNull
    private String accountNumber;

    private String typeSpecificId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AccountTypeEnum accountType;

    private Double balanceAmount;

    @NotNull
    private String branchId;

    @NotNull
    private CustomerDTO customer;

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountDTO setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getTypeSpecificId() {
        return typeSpecificId;
    }

    public AccountDTO setTypeSpecificId(String typeSpecificId) {
        this.typeSpecificId = typeSpecificId;
        return this;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public AccountDTO setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
        return this;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public AccountDTO setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }

    public String getBranchId() {
        return branchId;
    }

    public AccountDTO setBranchId(String branchId) {
        this.branchId = branchId;
        return this;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public AccountDTO setCustomer(CustomerDTO customer) {
        this.customer = customer;
        return this;
    }
}
