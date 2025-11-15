package com.school.model.example;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private List<Grade> grades = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        for (Grade grade : grades) {
            if (grade.getStudent().equals(student) && grade.getExam().equals(exam)) {
                return grade.getGradeAt(t);
            }
        }
        throw new IllegalArgumentException("No grade found for student " + student.getId() + " and exam " + exam.getId());
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        double sum = 0.0;
        double totalCoefficient = 0.0;
        for (Exam exam : exams) {
            if (exam.getCourse().equals(course)) {
                try {
                    double grade = getExamGrade(exam, student, t);
                    sum += grade * exam.getCoefficient();
                    totalCoefficient += exam.getCoefficient();
                } catch (IllegalArgumentException e) {
                    // Skip exams without grades
                }
            }
        }
        if (totalCoefficient == 0.0) {
            throw new IllegalArgumentException("No valid exams with coefficients found for course " + course.getId());
        }
        return sum / totalCoefficient;
    }
}
