package com.example.lecture13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Lecture13Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture13Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository studentRepository, AddressRepository addressRepository){
		return args -> {
			Address address= new Address();
			address.setAddress("Test address");
			address.setCity("BG");
			address= addressRepository.save(address);
			Student student = new Student("ExampleStudent");
			student.setAge(21);
			student.setAddress(Collections.singleton(address));
			student=studentRepository.save(student);

			Student student2 = new Student("ExampleStudent2");
			student2.setAge(22);
			student2.setAddress(Collections.singleton(address));
			student2=studentRepository.save(student2);

			System.out.println(studentRepository.findByFirstName("ExampleStudent"));
			System.out.println(studentRepository.findByAgeBetween(18,21));
			System.out.println(studentRepository.findByNon(21));
			System.out.println(studentRepository.findByAge(21));

			//studentRepository.findById(2L).orElseThrow();
		};
	}

}
