package com.interview.banking.onlineBankingService.authentication.login;

import com.interview.banking.onlineBankingService.authentication.constants.ErrorMessage;
import com.interview.banking.onlineBankingService.authentication.feignInterface.CustomerInterface;
import com.interview.banking.onlineBankingService.authentication.security.jwt.JwtTokenProvider;
import com.interview.banking.onlineBankingService.base.exceptions.UnauthorisedException;
import com.interview.banking.onlineBankingService.customer.dto.CustomerDTO;
import com.interview.banking.onlineBankingService.customer.dto.LoginRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomerInterface customerInterface;

    public String login(LoginRequestDTO requestDTO) {

        logger.info(requestDTO.getUsername() + " attempts to login on " + (System.currentTimeMillis()) + " ms");

        CustomerDTO userResponseDTO = customerInterface.fetchUserByUsername(requestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + requestDTO.getUsername() + " not found"));

        validatePassword(userResponseDTO, requestDTO);
        String jwtToken = jwtTokenProvider.createToken(requestDTO.getUsername());
        logger.info(requestDTO.getUsername() + " successfully logs in ");
        return jwtToken;
    }

    private void validatePassword(CustomerDTO userResponseDTO, LoginRequestDTO requestDTO) {
        if (!BCrypt.checkpw(requestDTO.getPassword(), userResponseDTO.getPassword())) {
            logger.debug("Incorrect password");
            throw new UnauthorisedException(ErrorMessage.INCORRECT_PASSWORD);
        }
    }

}
