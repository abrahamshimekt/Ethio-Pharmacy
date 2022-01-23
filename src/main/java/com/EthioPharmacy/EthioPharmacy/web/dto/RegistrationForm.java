package com.EthioPharmacy.EthioPharmacy.web.dto;
import com.EthioPharmacy.EthioPharmacy.models.User;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
