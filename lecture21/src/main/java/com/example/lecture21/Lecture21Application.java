package com.example.lecture21;

import com.example.lecture21.model.Charger;
import com.example.lecture21.model.Phone;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Lecture21Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture21Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(PhoneRepo phoneRepo, ChargerRepo chargerRepo){
		return args -> {
			Phone samsung=new Phone("S20", "Samsung", 6.0, 48.0);
			Phone iphone=new Phone("12", "iphone", 6.0, 48.0);
			Charger chargerC=new Charger();
			chargerC.setType("C");
			samsung.setCharger(chargerC);
			chargerRepo.save(chargerC);
			phoneRepo.save(samsung);
			phoneRepo.save(iphone);
			chargerC.getPhoneList().add(samsung);
			chargerRepo.save(chargerC);
			System.out.println(phoneRepo.findAll());
		};
	}

}
