package com.example.lecture21.model;

import javax.persistence.*;

@Entity
public class Phone {

    @GeneratedValue()
    @Id
    private Long id;

    @Column
    private String model;

    @Column
    private String manufacture;
    @Column
    private Double display;
    @Column
    private Double camera;

    @ManyToOne
    private Charger charger;

    public Phone() {
    }

    public Phone(String model, String manufacture, Double display, Double camera) {
        this.model = model;
        this.manufacture = manufacture;
        this.display = display;
        this.camera = camera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Double getDisplay() {
        return display;
    }

    public void setDisplay(Double display) {
        this.display = display;
    }

    public Double getCamera() {
        return camera;
    }

    public void setCamera(Double camera) {
        this.camera = camera;
    }
}
