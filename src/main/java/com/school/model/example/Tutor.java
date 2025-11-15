package com.school.model.example;

import java.time.LocalDate;

public class Tutor extends Person {
    private String description;

    public Tutor(int id, String name, String firstName, LocalDate birthDate, String email, String phone, String description) {
        super(id, name, firstName, birthDate, email, phone);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
