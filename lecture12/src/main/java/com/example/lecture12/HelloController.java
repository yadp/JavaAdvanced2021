package com.example.lecture12;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    List<Student> studentList = new ArrayList<Student>();

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false,
            defaultValue = "Yavor") String name,
                        Model model) {
        model.addAttribute("name", name);

        ArrayList<String> testList = new ArrayList<>();
        testList.add("test1");
        testList.add("test2");
        model.addAttribute("list", testList);

        Student testStudent = new Student("Petar", 20);
        model.addAttribute("student", testStudent);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(testStudent);
        studentList.add(new Student("Second", 21));

        model.addAttribute("students", studentList);

        return "hello";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "addUser";
    }

    @GetMapping("/student")
    public String getStudents(Model model) {
        model.addAttribute("students", studentList);
        return "Student";
    }

    @PostMapping("/student")
    public String postStudents(@ModelAttribute Student student, Model model){
        studentList.add(student);
        model.addAttribute("students", studentList);
        return "Student";
    }
}
