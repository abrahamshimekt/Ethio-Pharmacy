package com.EthioPharmacy.EthioPharmacy.service;

import com.EthioPharmacy.EthioPharmacy.models.User;
import com.EthioPharmacy.EthioPharmacy.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
    
}
