//package com.EthioPharmacy.EthioPharmacy.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name ="cart_items")
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name ="medicine_id")
//    private  Medicine medicine;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//    private int quantity;
//
//}
