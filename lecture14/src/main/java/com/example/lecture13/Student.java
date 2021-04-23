package com.example.lecture13;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table ( name="person")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "TestJoin",
            joinColumns = {@JoinColumn(name = "address_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    private Set<Address> address;

    public Student() {

    }

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
