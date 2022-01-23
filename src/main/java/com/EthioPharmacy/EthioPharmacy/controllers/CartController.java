package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.models.CartItem;
import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.repository.CartItemRepository;
import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
@SessionAttributes("medicineOrder")
@RequiredArgsConstructor
@Controller
public class CartController {
    @Autowired
    MedicineRepository medicineRepository;
    private final CartItemRepository cartItemRepository;
    @GetMapping("/home/diabetes")
    public String orderForm(Model model) {
        model.addAttribute("cartedItem", cartItemRepository.findAll());
        return "catagory/diabetes";
    }

    @PostMapping("/home/diabetes/carts")
    public String processOrder(@RequestParam(name="id") int id,
            @Valid CartItem cartItem, Errors errors, SessionStatus status,
                               @RequestParam(name = "quantity") int quantity) {
        if (errors.hasErrors()) {
            return "category/diabetes";
        }
        Medicine medicine= medicineRepository.findById(id).get();
        CartItem cartItem1 = new CartItem();
        cartItem1.getMedicine().add(medicine);
        cartItem1.setQuantity(quantity);
        cartItemRepository.save(cartItem1);



        status.setComplete();

        return "redirect:/userdashboard";
    }


}
