package com.EthioPharmacy.EthioPharmacy.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String company;
    private String address;
    private  String email;
    private String phone;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
   
    private Collection<Role> roles;

}
