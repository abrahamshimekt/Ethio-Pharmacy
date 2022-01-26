package com.EthioPharmacy.EthioPharmacy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signup")
public class SignupController {

    public String showSignUpPage() {
        return "signup";
    }
    
    
}
