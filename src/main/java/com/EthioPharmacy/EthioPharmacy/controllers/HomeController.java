package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "home")
public class HomeController {
    static ArrayList<Medicine> medicines = new ArrayList<>();
    @GetMapping
    public String showHome(Model model)
    {


        model.addAttribute("title", "OurProducts");
        model.addAttribute("medicines", medicines);
        return "meds/home";
    }

    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Medicine");
        return "meds/addMedForm";
    }

    @PostMapping("/add")
    public String processAddForm(@RequestParam String medName, @RequestParam String medPrice, @RequestParam String medDescription) {
        Medicine newMed = new Medicine( medName, medPrice, medDescription);
        medicines.add(newMed);
        return "redirect:/home";
    }
}
