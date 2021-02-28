package com.interview.banking.onlineBankingService.customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sangeetha on 28/02/2021.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpringSecurityPrincipal implements UserDetails {

    private static final long serialVersionUID = -7716421384050603153L;


    private Long organizationId;
    private String customerId;
    private String firstName;
    private String lastName;
    private String username;
    private List<SpringSecurityRole> roles = new ArrayList<SpringSecurityRole>();
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public SpringSecurityPrincipal setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public SpringSecurityPrincipal setUsername(String username) {
        this.username = username;
        return this;
    }

    public SpringSecurityPrincipal setAuthorities(List<SpringSecurityRole> authorities) {
        this.roles = authorities;
        return this;
    }

    public SpringSecurityPrincipal setPassword(String password) {
        this.password = password;
        return this;
    }

    public SpringSecurityPrincipal setIsAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
        return this;
    }

    public SpringSecurityPrincipal setIsAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
        return this;
    }

    public SpringSecurityPrincipal setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public SpringSecurityPrincipal setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    
    public SpringSecurityPrincipal addRole(SpringSecurityRole role){
        this.roles.add(role);
        return this;
    }

    public Boolean hasAuthority(String permission){
        for (SpringSecurityRole role: roles)
        {
            if (role.hasAuthority(permission))
                return true;
        }
        return false;
    }

    public List<String> getAllAuthoritiesForPrincipal(){
        List<String> authorities = new ArrayList<>();
        for (SpringSecurityRole role: roles)
        {
            authorities.addAll(role.getAuthorities());
        }
        return authorities;
    }

    public String getCustomerId() {
        return customerId;
    }

    public SpringSecurityPrincipal setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SpringSecurityPrincipal setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SpringSecurityPrincipal setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "SpringSecurityPrincipal{" +
                "organizationId='" + organizationId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
