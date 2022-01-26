package com.EthioPharmacy.EthioPharmacy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medName;
    private String  medPrice;
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "carted_medicine")
    private List<Medicine> medicine = new ArrayList<>();
    public CartItem(int id, String medName) {
        this.id = id;
        this.medName = medName;
    }
}