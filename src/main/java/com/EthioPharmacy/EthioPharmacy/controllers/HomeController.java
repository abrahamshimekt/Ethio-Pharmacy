package com.EthioPharmacy.EthioPharmacy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping
    public String showHome(Model model)
    {
        ArrayList<String> medicines = new ArrayList<>();
        medicines.add("Aspirin");
        medicines.add("methamin");
        medicines.add("thermophin");
        medicines.add("therm");
        model.addAttribute("title", "OurProducts");
        model.addAttribute("medicines", medicines);
        return "/home";
    }
}
