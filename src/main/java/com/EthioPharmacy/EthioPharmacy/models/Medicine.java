package com.EthioPharmacy.EthioPharmacy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "")
    @Size(min = 3, max = 15, message = "Enter a valid name")
    private String medName;
    @NotBlank(message = "")
    @Pattern(regexp = "^[$][0-9]+$", message = "Enter a valid price")
    private  String medPrice;
    @NotBlank(message = "")
    @Size(min = 5, message = "Enter a valid description")
    private String medDescription;
    @Lob
    @Column (columnDefinition = "MEDIUMBLOB")
    private String medImage;
    @ManyToOne
    private Catagory catagory;
    @ManyToOne
    private MedicineOrder medicineOrder;


}
