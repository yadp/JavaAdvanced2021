package com.example.lecture21.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Charger {

    @GeneratedValue()
    @Id
    private Long id;

    @Column
    private String type;

    @OneToMany
    private List<Phone> phoneList;

    public Charger() {
        phoneList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }




}
