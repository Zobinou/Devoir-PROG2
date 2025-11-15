package com.school.model.example;

import java.time.LocalDate;

public abstract class Person {
    private int id;
    private String name;
    private String firstName;
    private LocalDate birthDate;
    private String email;
    private String phone;

    public Person(int id, String name, String firstName, LocalDate birthDate, String email, String phone) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}