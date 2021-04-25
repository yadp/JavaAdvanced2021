package com.example.lecture202;


import com.example.lecture202.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepo phoneRepo;


    @GetMapping("/")
    public List<Phone> listAllPhones(){
        List<Phone> phones = new ArrayList<>();
        phoneRepo.findAll().forEach(phones::add);

        if(phones.size()==0){
            throw new NullPointerException();
        }

        return phones;
    }

    @PostMapping("/")
    public Phone createPhone(@RequestBody Phone phone){
        return phoneRepo.save(phone);
    }

    @PutMapping("/{id}")
    public Phone cretePhone(@PathVariable Long id, @RequestBody Phone phone){
        Optional<Phone> foundPhone= phoneRepo.findById(id);
        if(foundPhone.isEmpty()){
            throw  new NullPointerException();
        }
        Phone phoneToEdit = foundPhone.get();
        phoneToEdit.setDisplay(phone.getDisplay());
        phoneToEdit.setCamera(phone.getCamera());

        return phoneRepo.save(phoneToEdit);
    }

    @GetMapping("/search")
    public List<Phone> findManufacture(@RequestParam(name="manufacture", required = true) String manufacture){
        return phoneRepo.findByManufacture(manufacture);
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "sadsdasd")
    @ExceptionHandler(NullPointerException.class)
    public void noPhonesFound(){
    }


}
