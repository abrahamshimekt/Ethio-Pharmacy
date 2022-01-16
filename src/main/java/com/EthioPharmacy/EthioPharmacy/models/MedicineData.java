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

    public static Medicine getId(int id) {
        Medicine tempMed = null;
        for (Medicine medicine : medicines) {
            if (medicine.getMedId() == id) {
                tempMed = medicine;
            }
        }
        return tempMed;
    }

    public static void removeMed(int id) {
        Medicine removed = getId(id);
        medicines.remove(removed);
    }
}