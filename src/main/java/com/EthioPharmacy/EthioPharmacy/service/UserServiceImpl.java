package com.EthioPharmacy.EthioPharmacy.service;

import java.util.Arrays;

import com.EthioPharmacy.EthioPharmacy.models.Role;
import com.EthioPharmacy.EthioPharmacy.models.User;
import com.EthioPharmacy.EthioPharmacy.repository.UserRepository;
import com.EthioPharmacy.EthioPharmacy.web.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
@Service
@Data
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User  user = new User( registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getUserName(), registrationDto.getCompany(),registrationDto.getAddress(),registrationDto.getEmail() ,registrationDto.getPhone(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
}
