package com.example.lecture13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/country")
    public List<Country> findAllCountry(@RequestParam(name = "code", required = false) String countryCode){
        if(countryCode!=null){
            try {
                return Collections.singletonList(countryRepository.findById(countryCode).get());
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return countryRepository.findAll();
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable(name = "id") long id){
        return studentRepository.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) throws Exception {
        //TODO update data for student based on ID
        Optional<Student> foundStudent= studentRepository.findById(id);
        if(foundStudent.isEmpty()){
            //throw error
            throw new Exception("This is exception");
        } else {
            Student studentToReplace = foundStudent.get();
            studentToReplace.setFirstName(student.getFirstName());
            studentToReplace.setAge(student.getAge());
            studentRepository.save(studentToReplace);
            return studentToReplace;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}
