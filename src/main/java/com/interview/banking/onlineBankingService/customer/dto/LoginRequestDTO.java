package com.interview.banking.onlineBankingService.customer.dto;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable {

    private String username;

    private String password;


    public String getUsername() {
        return username;
    }

    public LoginRequestDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
