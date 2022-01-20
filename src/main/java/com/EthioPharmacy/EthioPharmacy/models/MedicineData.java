package com.EthioPharmacy.EthioPharmacy.models;
import java.util.ArrayList;

public class MedicineData {
    
    static ArrayList<Medicine> medicines = new ArrayList<>();

    public static ArrayList<Medicine> getAllMeds() {
        return medicines;
    }

    public static void addMed(Medicine medicineIn) {
        medicines.add(medicineIn);
    }
}
