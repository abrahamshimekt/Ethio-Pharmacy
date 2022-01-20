package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.models.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class adminPageController {
    @Autowired
    MedicineRepository medicineRepository;
    @GetMapping
    public String displayAdminDashBoard(Model model) {
        model.addAttribute("title", "DashBoard");
        model.addAttribute("medicines", medicineRepository.findAll());
        return "meds/admin";
    }
}
