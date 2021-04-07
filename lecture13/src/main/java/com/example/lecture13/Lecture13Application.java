package com.example.lecture13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lecture13Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture13Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository studentRepository){
		return args -> {
			Student student = new Student("ExampleStudent");
			student.setAge(21);
			studentRepository.save(student);
			System.out.println(studentRepository.findByFirstName("ExampleStudent"));
			System.out.println(studentRepository.findByAgeBetween(18,21));
			System.out.println(studentRepository.findByNon(21));
			System.out.println(studentRepository.findByAge(21));

			studentRepository.findById(1L).orElseThrow();
		};
	}

}
