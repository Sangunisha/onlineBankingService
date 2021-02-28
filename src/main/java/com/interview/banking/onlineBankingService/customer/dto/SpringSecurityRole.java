package com.interview.banking.onlineBankingService.customer.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeetha on 28/02/2021.
 */
public class SpringSecurityRole implements GrantedAuthority {

    private String role;
    private List<String> authorities = new ArrayList<String>();

    public SpringSecurityRole(String role) {
        this.role = role;
    }

    public SpringSecurityRole() {
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public SpringSecurityRole setRole(String role) {
        this.role = role;
        return this;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public SpringSecurityRole setAuthorities(List<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public SpringSecurityRole addAuthority(String permission) {
        this.authorities.add(permission);
        return this;
    }

    public Boolean hasAuthority(String authority) {
        return this.authorities.contains(authority);
    }

}
