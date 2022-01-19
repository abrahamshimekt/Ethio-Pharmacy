package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Medicines3Controller {
    @GetMapping("/medicine3")
    public String showMedicine() {
        return "medicines3";
    }
}
