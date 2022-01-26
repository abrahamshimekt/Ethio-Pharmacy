package com.EthioPharmacy.EthioPharmacy.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EyecareController {
    @GetMapping("/eyecare")
    public String showMedicine() {
        return "eyecare";
    }
}
