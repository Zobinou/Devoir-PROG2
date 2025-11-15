package com.school.model.example;

import java.time.Instant;

public class GradeChange {
    private double value;
    private Instant time;
    private String reason;

    public GradeChange(double value, Instant time, String reason) {
        this.value = value;
        this.time = time;
        this.reason = reason;
    }

    public double getValue() {
        return value;
    }

    public Instant getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }
}