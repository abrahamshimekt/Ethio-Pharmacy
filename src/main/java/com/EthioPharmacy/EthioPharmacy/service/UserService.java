package com.EthioPharmacy.EthioPharmacy.service;

import com.EthioPharmacy.EthioPharmacy.models.User;
import com.EthioPharmacy.EthioPharmacy.web.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    
}
