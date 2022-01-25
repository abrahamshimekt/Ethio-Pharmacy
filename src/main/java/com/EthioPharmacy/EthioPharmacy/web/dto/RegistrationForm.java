package com.EthioPharmacy.EthioPharmacy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String UserName;
    private String company;
    private String address;
    private String email;
    private String phone;
    private String password;

}
