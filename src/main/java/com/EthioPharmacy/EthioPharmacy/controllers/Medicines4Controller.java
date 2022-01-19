package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Medicines4Controller {
    @GetMapping("/medicine4")
    public String showMedicine() {
        return "medicines4";
    }
}
