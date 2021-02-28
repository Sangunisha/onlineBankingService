package com.interview.banking.onlineBankingService.account.dto;

import javax.validation.constraints.NotNull;


public class AccountStatementRequestDTO {

    @NotNull
    private String accountId;

    private Integer pageSize;
    private Integer page;

    public String getAccountId() {
        return accountId;
    }

    public AccountStatementRequestDTO setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public AccountStatementRequestDTO setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public AccountStatementRequestDTO setPage(Integer page) {
        this.page = page;
        return this;
    }
}
