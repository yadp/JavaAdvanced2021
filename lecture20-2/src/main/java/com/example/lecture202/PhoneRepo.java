package com.example.lecture202;

import com.example.lecture202.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepo extends JpaRepository<Phone,Long> {

    List<Phone> findByManufacture(String manufacture);
}
