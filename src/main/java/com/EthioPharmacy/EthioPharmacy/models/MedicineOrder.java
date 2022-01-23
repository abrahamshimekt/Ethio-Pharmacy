//package com.EthioPharmacy.EthioPharmacy.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.validator.constraints.CreditCardNumber;
//
//import javax.persistence.*;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import java.util.ArrayList;
//import java.util.List;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class MedicineOrder {
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @NotBlank(message = "Delivery name is required")
//    private String deliveryName;
//    @NotBlank(message = "Delivery street is required")
//    private String deliveryStreet;
//    @NotBlank(message = "Delivery city is required")
//    private String deliveryCity;
//    @NotBlank(message = "Delivery state is required")
//    private String deliveryState;
//    @NotBlank(message = "Delivery zip is required")
//    private String deliveryZip;
//    @CreditCardNumber(message = "Not a valid credit card number")
//    private String ccNumber;
//    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
//    private String ccExpiration;
//    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
//    private String ccCVV;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "medicines_orders",
//            joinColumns = @JoinColumn(
//                    name = "medicine_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "order_id", referencedColumnName = "id"))
//    private List<Medicine> medicines = new ArrayList<>();
//    public void addMedicine(Medicine medicine){
//        this.medicines.add(medicine);
//    }
//
//
//}
