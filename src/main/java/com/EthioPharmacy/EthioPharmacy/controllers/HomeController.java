package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.models.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(path = "")
public class HomeController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping
    public String showHome(Model model)
    {
        model.addAttribute("title", "OurProducts");
        model.addAttribute("medicines", medicineRepository.findAll());
        return "index";
    }



    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Medicine");
        model.addAttribute(  new Medicine());
        return "meds/addMedForm";
    }

    @PostMapping("/add")
    public String processAddForm(@ModelAttribute @Valid  Medicine newMed, Errors errors, Model model) {
        // what modelAttribute does
        // Medicine newMed = new Medicine();
        // newMed.setName(Request.getParameter("name"))---> it will match the form name attr to the object attr
        // newmed.setDescription(Request.getParameter("description") --> >>        description       >>  >>
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Medicine");
            return "meds/addMedForm";
        }
        medicineRepository.save(newMed);

        return "redirect:/user";
    }

    @GetMapping("/addedProduct")
    public String showAddedProducts(Model model) {
        model.addAttribute("medicines", medicineRepository.findAll());
        model.addAttribute("selected" , new Medicine());
        return "meds/addedProducts";
    }



    @PostMapping("/addedProduct")
    public String processRemovedProduct(  @RequestParam int[] medIds) {

        for(int medId : medIds) {
            medicineRepository.deleteById(medId);
        }
        return "redirect:addedProduct";
    }


}
