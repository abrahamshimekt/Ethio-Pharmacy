package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.models.MedicineData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "home")
public class HomeController {

    @GetMapping
    public String showHome(Model model)
    {
        model.addAttribute("title", "OurProducts");
        model.addAttribute("medicines", MedicineData.getAllMeds());
        return "meds/home";
    }

    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Medicine");
        return "meds/addMedForm";
    }

    @PostMapping("/add")
    public String processAddForm(@ModelAttribute Medicine newMed) {
        // what modelAttribute does
        // Medicine newMed = new Medicine();
        // newMed.setName(Request.getParameter("name"))---> it will match the form name attr to the object attr
        // newmed.setDescription(Request.getParameter("description") --> >>        description       >>  >>
        MedicineData.addMed(newMed);
        return "redirect:/home";
    }

    @GetMapping("/addedProduct")
    public String showAddedProducts(Model model) {
        model.addAttribute("medicines", MedicineData.getAllMeds());
        return "meds/addedProducts";
    }



    @PostMapping("/addedProduct")
    public String processRemovedProduct(@RequestParam int[] medIds) {
        for(int medId : medIds) {
            MedicineData.removeMed(medId);
        }
        return "redirect:addedProduct";
    }


}
