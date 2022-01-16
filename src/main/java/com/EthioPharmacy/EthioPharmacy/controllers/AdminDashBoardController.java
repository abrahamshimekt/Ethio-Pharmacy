package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.models.MedicineData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(path = "adminDashBoard")
public class AdminDashBoardController {

    @GetMapping
    public String showHome(Model model)
    {
        model.addAttribute("title", "OurProducts");
        model.addAttribute("medicines", MedicineData.getAllMeds());
        return "meds/adminDashBoard";
    }

    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Medicine");
        return "meds/addMedForm";
    }

    @PostMapping("/add")
    public String processAddForm(@RequestParam String medName, @RequestParam String medPrice, @RequestParam String medDescription) {
        Medicine newMed = new Medicine( medName, medPrice, medDescription);
        MedicineData.addMed(newMed);


        return "redirect:/adminDashBoard";
    }

    @GetMapping("/addedProduct")
    public String showAddedProducts(Model model) {
        model.addAttribute("medicines", MedicineData.getAllMeds());
        return "meds/addedProducts";
    }

    @PostMapping("/removeProduct")
    public String processRemovedProduct(@RequestParam int[] medIds) {
        for(int medId : medIds) {
            MedicineData.removeMed(medId);
        }
        return "meds/addedProducts";
    }


}
