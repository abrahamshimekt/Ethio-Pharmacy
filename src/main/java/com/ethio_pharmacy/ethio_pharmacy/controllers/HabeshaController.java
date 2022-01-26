package com.EthioPharmacy.EthioPharmacy.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabeshaController {
    @GetMapping("/habesha")
    public String showMedicine() {
        return "habesha";
    }
}
