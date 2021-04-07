package com.example.lecture11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {


    @Autowired
    List<Animal> zoo;


    @Value("${test}")
    private String var;

    @Value("${email}")
    private String email;




    @GetMapping("/hello")
    public String hello(){
        return "Hello This is the firm. You can contact us on " + email;
    }

    @GetMapping("/animal")
    public List<Animal> animal(@RequestParam(name = "animal", required = false) String animalName){
        if(animalName!=null){
            List<Animal> animalsToReturn=new ArrayList<>();
            for(Animal animal:zoo){
                if(animal.getName().equals(animalName)){
                    animalsToReturn.add(animal);
                }
            }
            return animalsToReturn;
        } else {
            return zoo;
        }
    }

    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody Animal animal){
        System.out.println(animal);
        zoo.add(animal);
        return animal;
    }

    //@PutMapping Update Object
    @PutMapping("/animal")
    public Animal updateAnimal(@RequestBody Animal animal){
        String name = animal.getName();
        for(Animal updateAnimal: zoo){
            if(name.equals(updateAnimal.getName())){
                updateAnimal.setAge(animal.getAge());
                return updateAnimal;
            }
        }
        return null;
    }

    //@DeleteMapping Delete Object
    @DeleteMapping("/animal")
    public Animal deleteAnimal(@RequestParam (name = "animal", required = true) String animalName){
        for(Animal deleteAnimal:zoo){
            if(animalName.equals(deleteAnimal.getName())){
                zoo.remove(deleteAnimal);
                return deleteAnimal;
            }
        }
        return null;
    }
}
