package com.EthioPharmacy.EthioPharmacy.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.EthioPharmacy.EthioPharmacy.models.Role;
import com.EthioPharmacy.EthioPharmacy.models.User;
import com.EthioPharmacy.EthioPharmacy.repository.UserRepository;
import com.EthioPharmacy.EthioPharmacy.web.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.Data;
@Service
@Data
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User  user = new User( registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getUserName(), registrationDto.getCompany(),registrationDto.getAddress(),registrationDto.getEmail() ,registrationDto.getPhone(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user ==null){
            throw new UsernameNotFoundException("invalid user or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
