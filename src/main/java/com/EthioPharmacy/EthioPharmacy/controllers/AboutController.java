package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @Configuration
@ComponentScan("com.baeldung.packageA")
public class AboutController {
    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }
}
