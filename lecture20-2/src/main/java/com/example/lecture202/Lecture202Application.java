package com.example.lecture21;

import com.example.lecture21.model.Phone;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lecture202Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture202Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(PhoneRepo phoneRepo){
		return args -> {
			Phone samsung=new Phone("S20", "Samsung", 6.0, 48.0);
			Phone iphone=new Phone("12", "iphone", 6.0, 48.0);
			//phoneRepo.save(samsung);
			//phoneRepo.save(iphone);
			System.out.println(phoneRepo.findAll());
		};
	}

}
