// package com.EthioPharmacy.EthioPharmacy.service;

// import com.EthioPharmacy.EthioPharmacy.models.Role;
// import com.EthioPharmacy.EthioPharmacy.models.User;
// import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
// import com.EthioPharmacy.EthioPharmacy.web.dto.RegistrationForm;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.Collection;
// import java.util.Set;
// import java.util.stream.Collectors;
// @Service
// public class CustomUserDetailsService implements UserDetailsService {
//         @Autowired
//         private MedicineRepository userRepository;
//         @Autowired
//         private BCryptPasswordEncoder passwordEncoder;

//         public CustomUserDetailsService(MedicineRepository userRepository) {
//             super();
//             this.userRepository = userRepository;
//         }

//         public User save(RegistrationForm form) {
//             User user = new User(form.getFirstName(),
//                     form.getLastName(), form.getEmail(),
//                     passwordEncoder.encode(form.getPassword()), Set.of(new Role("ROLE_USER")));

//             return userRepository.save(user);
//         }

//         @Override
//         public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//             User user = userRepository.findByEmail(email);
//             if(user != null) {
//                 return new CustomUserDetails(user);
//             }
//             throw new UsernameNotFoundException("Invalid user email or password");
//         }

//         private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//             return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//         }

// }


