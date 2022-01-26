package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.service.CustomUserDetailsService;
import com.EthioPharmacy.EthioPharmacy.web.dto.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
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



    @GetMapping("/signup")
    public String registerUserAccount( @ModelAttribute("user") RegistrationForm form,Model model) {
        model.addAttribute("form",form);

        return "signup";
    }
    @PostMapping("/signup")
    public String register(@Valid RegistrationForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "signup";
        }
        customUserDetailsService.save(form);
        return "redirect:/login";
    }
}



