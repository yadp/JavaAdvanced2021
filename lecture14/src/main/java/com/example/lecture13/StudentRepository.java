package com.example.lecture13;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByAgeBetween(int a, int b);

    List<Student> findByAge(int age);

    @Query("select s from Student s where s.age=?1")
    List<Student> findByNon(int age);
}
