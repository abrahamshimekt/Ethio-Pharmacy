package com.EthioPharmacy.EthioPharmacy.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StdController {
    @GetMapping("/std")
    public String showMedicine() {
        return "std";
    }
}
