package com.school.model.example;

import java.time.LocalDate;

public class Teacher extends Person {
    private String specialty;

    public Teacher(int id, String name, String firstName, LocalDate birthDate, String email, String phone, String specialty) {
        super(id, name, firstName, birthDate, email, phone);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}
