package com.EthioPharmacy.EthioPharmacy.service;


import com.EthioPharmacy.EthioPharmacy.models.Catagory;
import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private CatagoryRepository catagoryRepository;


}


