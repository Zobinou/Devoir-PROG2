package com.school.model.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Student student;
    private Exam exam;
    private List<GradeChange> changes = new ArrayList<>();

    public Grade(Student student, Exam exam) {
        this.student = student;
        this.exam = exam;
    }

    public void addChange(double value, Instant time, String reason) {
        changes.add(new GradeChange(value, time, reason));
    }

    public double getGradeAt(Instant t) {
        GradeChange latest = null;
        for (GradeChange change : changes) {
            if (change.getTime().equals(t) || change.getTime().isBefore(t)) {
                if (latest == null || change.getTime().isAfter(latest.getTime())) {
                    latest = change;
                }
            }
        }
        if (latest == null) {
            throw new IllegalStateException("No grade changes found before or at " + t);
        }
        return latest.getValue();
    }

    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }
}
