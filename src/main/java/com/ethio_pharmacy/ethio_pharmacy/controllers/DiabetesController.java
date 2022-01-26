package com.EthioPharmacy.EthioPharmacy.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiabetesController {
    @GetMapping("/diabetes")
    public String showMedicine() {
        return "diabetes";
    }
}
