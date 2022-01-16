package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignupController {
    @GetMapping(value="/signup")
    public String signUp() {
        return "meds/signup";
    }
    
    
}
