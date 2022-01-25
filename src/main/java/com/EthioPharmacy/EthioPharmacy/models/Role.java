package com.EthioPharmacy.EthioPharmacy.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table (name ="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Role(String name) {
        super();
        this.name = name;
    }

}
