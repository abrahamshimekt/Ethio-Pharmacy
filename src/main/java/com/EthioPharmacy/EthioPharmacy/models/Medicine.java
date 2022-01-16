package com.EthioPharmacy.EthioPharmacy.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Medicine {
    @NotNull
    @Size(min = 3, max = 15, message = "Enter a valid name")
    private   String medName;
    @Pattern(regexp = "^[$][0-9]+$", message = "Enter a valid price")
    private   String medPrice;
    @NotNull
    @Size(min = 1, message = "Enter a valid description")
    private   String medDescription;
    private int medId;
    private static int nextMedId = 1;

    public Medicine(String medName, String medPrice, String medDescription) {
        this();
        this.medName = medName;
        this.medPrice = medPrice;
        this.medDescription = medDescription;

    }

    public Medicine() {
        medId = nextMedId;
        nextMedId++;
    }
}
