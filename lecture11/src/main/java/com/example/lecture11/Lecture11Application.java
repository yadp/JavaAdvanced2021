package com.example.lecture11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Lecture11Application {

	public static Logger logger = LoggerFactory.getLogger(Lecture11Application.class);

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		logger.info("This is info log example");
		SpringApplication.run(Lecture11Application.class, args);
	}

	@Bean
	public CommandLineRunner test() {
		return (args) -> {
			String[] beans = applicationContext.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean : beans) {
				System.out.println(bean);
			}
		};
	}


	@Bean
	public Animal getAnimal(){
		return new Animal("Test",1);
	}

	@Bean
	public Animal get2Animal(){
		return new Animal("Second",2);
	}

	@Bean
	public List<Animal> getZoo(){
		return new ArrayList<Animal>();
	}

}
