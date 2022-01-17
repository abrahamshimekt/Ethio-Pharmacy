package com.EthioPharmacy.EthioPharmacy.service;

import java.util.Arrays;

import javax.enterprise.concurrent.LastExecution;

import com.EthioPharmacy.EthioPharmacy.models.Role;
import com.EthioPharmacy.EthioPharmacy.models.User;
import com.EthioPharmacy.EthioPharmacy.repository.UserRepository;
import com.EthioPharmacy.EthioPharmacy.web.dto.UserRegistrationDto;

import org.springframework.stereotype.Service;

import lombok.Data;
@Service
@Data
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User  user = new User(null, registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),null, Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
}
