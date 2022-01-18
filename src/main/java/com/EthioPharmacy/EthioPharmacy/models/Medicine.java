package com.EthioPharmacy.EthioPharmacy.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Enter a valid name")
    private   String medName;
    @Pattern(regexp = "^[$][0-9]+$", message = "Enter a valid price")
    private   String medPrice;
    @NotNull
    @Size(min = 1, message = "Enter a valid description")
    private   String medDescription;


    public Medicine() {

    }
}
