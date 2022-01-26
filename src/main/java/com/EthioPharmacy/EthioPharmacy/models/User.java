package com.EthioPharmacy.EthioPharmacy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

//user pojo
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min=2 ,max=15,message="length should be between 2 and 15")
    private String firstName;
    @Size(min=2 ,max=15,message="length should be between 2 and 15")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message="Email field shouldn't be empty")
    @Email(regexp = "^(.+)@(.+)$",message="invalid email")
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Set<Role> roles= new HashSet<>();
    public User(String firstName, String lastName, String email, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public boolean hasRole(String roleName){
        for (Role role : this.roles) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
