package com.EthioPharmacy.EthioPharmacy.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name ="role")
public class Role {
    private Long id;
      
}
