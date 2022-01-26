package com.EthioPharmacy.EthioPharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class EthioPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EthioPharmacyApplication.class, args);
	}

	@Controller
	@RequestMapping( path = "/home")
	public static class HomeController {

		@GetMapping("/")
		public String showHome(Model model) {

			return "index";
		}
	}
}
