package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Medicines2Controller {
    @GetMapping("/medicine2")
    public String showMedicine() {
        return "medicines2";
    }
}
