package com.EthioPharmacy.EthioPharmacy.models;

import lombok.Data;

@Data
public class Medicine {

    private  final String medName;
    private  final String medPrice;
    private  final String medDescription;
    private int medId;
    private static int nextMedId = 1;

    public Medicine(String medName, String medPrice, String medDescription) {
        this.medName = medName;
        this.medPrice = medPrice;
        this.medDescription = medDescription;
        medId = nextMedId;
        nextMedId++;
    }

}
