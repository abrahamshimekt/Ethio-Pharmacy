package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicinePageController {
    @GetMapping("/medicine")
    public String showMedicine(){
        return "medicinesPage";
    }
    
}
