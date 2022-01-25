package com.EthioPharmacy.EthioPharmacy.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UserDashBoardController {
    @GetMapping("/userdashboard")
    public String showUserDashBoard(){
        return "userdashboard";
    }
}
