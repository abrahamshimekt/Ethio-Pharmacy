package com.EthioPharmacy.EthioPharmacy.controllers;

import com.EthioPharmacy.EthioPharmacy.models.MedicineOrder;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


@SessionAttributes("medicineOrder")
@RequiredArgsConstructor
@Controller
public class OrderController {

    private final MedicineOrderRepository medicineOrderRepository;
    @GetMapping("/orders/current")
    public String orderForm(Model model) {
        model.addAttribute("medicineOrder", new MedicineOrder());
        return "meds/orderform";
    }
    @PostMapping("/orders")
    public String processOrder(@Valid MedicineOrder order, Errors errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "meds/orderform";
        }
        this.medicineOrderRepository.save(order);
        status.setComplete();

        return "redirect:/userdashboard";
    }
}
