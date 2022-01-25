package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/")
public class CatagoryController {
    @GetMapping
    public String showHome(Model model)
    {
        return "home";
    }
}
