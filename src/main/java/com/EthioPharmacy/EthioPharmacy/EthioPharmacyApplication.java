package com.EthioPharmacy.EthioPharmacy;

import com.EthioPharmacy.EthioPharmacy.models.Catagory;
import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EthioPharmacyApplication {

	public static void main(String[] args) {SpringApplication.run(EthioPharmacyApplication.class, args);}

	@Bean
	public CommandLineRunner dataLoader(CatagoryRepository repo) {
		return args -> {

			repo.save(new Catagory(1, "HABESHA"));
			repo.save(new Catagory(2, "DIABETES"));
			repo.save(new Catagory(3, "EYECARE"));
			repo.save(new Catagory(5, "STD"));

		};
	}
}
