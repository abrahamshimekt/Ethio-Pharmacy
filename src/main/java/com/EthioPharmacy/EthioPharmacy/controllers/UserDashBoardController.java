package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.repository.MedicineOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDashBoardController {
    @GetMapping("/userdashboard")
    public String showUserDashBoard() {
        return "meds/userdashboard";
    }

    @Autowired
    private MedicineOrderRepository repository;

    @GetMapping({"/userdashboard/orders"})
    public ModelAndView getAllOrders() {
        ModelAndView mav = new ModelAndView("meds/userdashboard");
        mav.addObject("orders", repository.findAll());
        return mav;
    }
}