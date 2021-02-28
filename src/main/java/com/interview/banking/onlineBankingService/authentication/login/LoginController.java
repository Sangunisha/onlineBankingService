package com.interview.banking.onlineBankingService.authentication.login;

import com.interview.banking.onlineBankingService.customer.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public String loginUser(@RequestBody LoginRequestDTO requestDTO) {

        return loginService.login(requestDTO);
    }
}
