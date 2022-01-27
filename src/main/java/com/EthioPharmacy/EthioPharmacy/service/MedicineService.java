package com.EthioPharmacy.EthioPharmacy.service;


import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private CatagoryRepository catagoryRepository;


}


