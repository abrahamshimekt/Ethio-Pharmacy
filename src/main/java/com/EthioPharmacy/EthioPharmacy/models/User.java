package com.EthioPharmacy.EthioPharmacy.models;

import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//user pojo
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames="userName"))
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
    private String company;
    private String address;
    private  String email;
    private String phone;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name ="user_id",
                    referencedColumnName ="id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName="id"))
    private Collection<Role> roles;

    public User(String firstName, String lastName, String userName, String company, String address, String email, String phone, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.company = company;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
