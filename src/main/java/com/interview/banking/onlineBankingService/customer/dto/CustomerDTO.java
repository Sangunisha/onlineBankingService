package com.interview.banking.onlineBankingService.customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.interview.banking.onlineBankingService.base.dto.BaseDTO;
import com.interview.banking.onlineBankingService.base.constants.GenderTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO extends BaseDTO<CustomerDTO> implements Serializable {

    //  @Size(min = 8, max = 8)
   // @NotNull
    private String customerId;

    private String password;

    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GenderTypeEnum gender;

    private Integer age;

    @NotNull
    private String emailId;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String userRole;

    @NotNull
    private String address;

    @NotNull
    private String state;

    @NotNull
    private String country;

    public String getCustomerId() {
        return customerId;
    }

    public CustomerDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomerDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public CustomerDTO setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GenderTypeEnum getGender() {
        return gender;
    }

    public CustomerDTO setGender(GenderTypeEnum gender) {
        this.gender = gender;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public CustomerDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public CustomerDTO setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public CustomerDTO setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getState() {
        return state;
    }

    public CustomerDTO setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CustomerDTO setCountry(String country) {
        this.country = country;
        return this;
    }
}
