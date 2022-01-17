package com.EthioPharmacy.EthioPharmacy.web.dto;
import lombok.Data;
@Data
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String UserName;
    private String company;
    private String address;
    private String email;
    private String phone;
    private String password;

}
