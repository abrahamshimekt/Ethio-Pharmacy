package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String getLoginFrom() {
        return "meds/login";
    }

    @RequestMapping(value ="/login",method=RequestMethod.POST)
    public String Login(@ModelAttribute(name="User") User loginForm,Model model){
        String username = loginForm.getUserName();
        String password = loginForm.getPassword();
        if ("admin".equals(username) && "admin".equals(password)){
            return "meds/adminDashBoard";
        }
        return "meds/login";
    }
    }
    

