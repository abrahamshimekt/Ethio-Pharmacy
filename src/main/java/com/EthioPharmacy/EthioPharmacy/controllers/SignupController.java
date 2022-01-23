package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.service.CustomUserDetailsService;
import com.EthioPharmacy.EthioPharmacy.web.dto.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signup")
public class SignupController {
    private CustomUserDetailsService customUserDetailsService;

    public SignupController(CustomUserDetailsService customUserDetailsService) {
        super();
        this.customUserDetailsService= customUserDetailsService;
    }

    @ModelAttribute("user")
    public RegistrationForm userRegistrationDto() {
        return new RegistrationForm();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") RegistrationForm form) {
            customUserDetailsService.save(form);
            return "redirect:/signup?success";
        }
}



