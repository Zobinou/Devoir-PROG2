package com.school.model.example;

import java.time.Instant;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant dateTime;
    private double coefficient;

    public Exam(int id, String title, Course course, Instant dateTime, double coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.dateTime = dateTime;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Course getCourse() {
        return course;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
