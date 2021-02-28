package com.interview.banking.onlineBankingService.authentication.security;

import com.interview.banking.onlineBankingService.authentication.feignInterface.CustomerInterface;
import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;
import com.interview.banking.onlineBankingService.customer.dto.SpringSecurityPrincipal;
import com.interview.banking.onlineBankingService.customer.dto.SpringSecurityRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private CustomerInterface customerInterface;

    public CustomUserDetailsService(CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerDTO userResponseDTO = customerInterface.fetchUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + username + " not found"));

        List<SpringSecurityRole> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SpringSecurityRole(userResponseDTO.getUserRole()));
        SpringSecurityPrincipal springSecurityPrincipal = new SpringSecurityPrincipal();
        springSecurityPrincipal.setUsername("" + userResponseDTO.getEmailId())
                .setPassword(userResponseDTO.getPassword())
                .setIsAccountNonExpired(true)
                .setIsAccountNonLocked(true)
                .setCredentialsNonExpired(true)
                .setAuthorities(grantedAuthorities)
                .setCustomerId(userResponseDTO.getId());
        return springSecurityPrincipal;
    }
}
