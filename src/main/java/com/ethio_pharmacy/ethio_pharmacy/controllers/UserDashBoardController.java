package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserDashBoardController {
    @GetMapping("/userdashboard")
    public String showUserDashBoard(){
        return "meds/userdashboard";
    }
}
