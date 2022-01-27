package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/home")
public class CatagoryController {

    @Autowired
    MedicineRepository medicineRepository;


    @Autowired
    private CatagoryRepository catagoryRepository;



    @GetMapping("/habesha")
    public String showMed(Model model){
        List<Medicine> medicineList = new ArrayList<>();
        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));

        List<Medicine> habeshaMed = medicineList.stream()
                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("habesha"))
                .collect(Collectors.toList());
        model.addAttribute("habesha", habeshaMed);
        return "category/habesha";
    }

    @GetMapping(path = "/eyecare")
    public String showEyecare(Model model)
    {
        List<Medicine> medicineList = new ArrayList<>();
        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));

        List<Medicine> eyeCareMed = medicineList.stream()
                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("eyecare"))
                .collect(Collectors.toList());
        model.addAttribute("eyecare", eyeCareMed);
        return "category/eyecare";
    }

    @GetMapping(path = "/diabets")
    public String showDiabets(Model model)
    {
        List<Medicine> medicineList = new ArrayList<>();
        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));

        List<Medicine> diabetesMed = medicineList.stream()
                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("diabetes"))
                .collect(Collectors.toList());
        model.addAttribute("diabetes", diabetesMed);
        return "category/diabets";
    }

    @GetMapping(path = "/std")
    public String showStd(Model model)
    {
        List<Medicine> medicineList = new ArrayList<>();
        this.medicineRepository.findAll().forEach(i ->medicineList.add(i));

        List<Medicine> stdMed = medicineList.stream()
                .filter(medicine -> medicine.getCatagory().getName().equalsIgnoreCase("std"))
                .collect(Collectors.toList());
        model.addAttribute("std", stdMed);
        return "category/std";
    }

}
