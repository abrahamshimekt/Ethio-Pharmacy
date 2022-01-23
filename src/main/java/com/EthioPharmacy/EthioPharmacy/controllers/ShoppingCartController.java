//package com.EthioPharmacy.EthioPharmacy.controllers;
//
//import com.EthioPharmacy.EthioPharmacy.models.CartItem;
//import com.EthioPharmacy.EthioPharmacy.models.User;
//import com.EthioPharmacy.EthioPharmacy.service.CustomUserDetailsService;
//import com.EthioPharmacy.EthioPharmacy.service.ShoppingCartServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class ShoppingCartController {
//
//    @Autowired
//    private ShoppingCartServices cartServices;
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//    @GetMapping("/cart")
//    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication) {
//        User user = customUserDetailsService.getCurrentlyLoggedInCustomer(authentication);
//        List<CartItem> listCartItems = cartServices.listCartItems(user);
//        model.addAttribute("listCartItems",listCartItems);
//        model.addAttribute("pageTitle","Shopping Cart");
//        return "shopingcart";
//
//    }
//}
