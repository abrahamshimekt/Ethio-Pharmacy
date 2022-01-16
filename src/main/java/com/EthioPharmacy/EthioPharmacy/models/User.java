package com.EthioPharmacy.EthioPharmacy.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name="username")
    private String userName;
    private  String email;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name ="user_id", referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id"))
    private Collection<Role> roles;

    
}
