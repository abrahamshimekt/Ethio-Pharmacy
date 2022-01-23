package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value="/")
public class AdminDashBoardController {

    @Autowired
    private MedicineRepository medicineRepository;
    @RequestMapping(value="/admindashboard",method=RequestMethod.GET)
    public ModelAndView admin(){
        ModelAndView model = new ModelAndView();
        model.setViewName("meds/admindashboard");
        return model;
    }
    @RequestMapping(value ="/home/**",method=RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView model = new ModelAndView();
        model.setViewName("meds/userdashboard");
        return model;
    }
//    @GetMapping("/admindashboard")
//    public String displayAdminDashBoard(Model model) {
//        model.addAttribute("title", "DashBoard");
//        model.addAttribute("medicines", medicineRepository.findAll());
//        return "meds/admindashboard";
//    }
    @GetMapping("/home/medicine")
    public String showMed(Model model){
        model.addAttribute("medicines", medicineRepository.findAll());
        return "medicine";

    }
    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Medicine");
        model.addAttribute(  new Medicine());
        return "meds/addmedform";
    }

    @PostMapping("/add")
    public String processAddForm(@ModelAttribute @Valid Medicine newMed, Errors errors, Model model) {
        // what modelAttribute does
        // Medicine newMed = new Medicine();
        // newMed.setName(Request.getParameter("name"))---> it will match the form name attr to the object attr
        // newmed.setDescription(Request.getParameter("description") --> >>        description       >>  >>
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Medicine");
            return "meds/addmedform";
        }
        medicineRepository.save(newMed);

        return "redirect:/home/medicine";
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
