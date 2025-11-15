package com.school.model.example;

import java.time.LocalDate;

public class Student extends Person {
    private String group;
    private Tutor tutor;

    public Student(int id, String name, String firstName, LocalDate birthDate, String email, String phone, String group, Tutor tutor) {
        super(id, name, firstName, birthDate, email, phone);
        this.group = group;
        this.tutor = tutor;
    }

    public String getGroup() {
        return group;
    }

    public Tutor getTutor() {
        return tutor;
    }
}