package com.school.model.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

    private Course course;

    @BeforeEach
    void setUp() {
        
        Teacher teacher = new Teacher(1, "Brown", "Bob", null, "bob@example.com", "111222", "back-end");
        course = new Course(1, "PROG1", 5, teacher);
    }

    @Test
    void testExamCreationAndGetters() {
        
        int id = 1;
        String title = "Midterm";
        Instant dateTime = Instant.parse("2025-11-16T20:54:00Z"); // Current date and time
        double coefficient = 2.0;

        
        Exam exam = new Exam(id, title, course, dateTime, coefficient);

       
        assertEquals(id, exam.getId(), "The exam ID must match");
        assertEquals(title, exam.getTitle(), "The exam title must match");
        assertEquals(course, exam.getCourse(), "The exam course must match");
        assertEquals(dateTime, exam.getDateTime(), "The exam date/time must match");
        assertEquals(coefficient, exam.getCoefficient(), "The exam coefficient must match");
    }

    @Test
    void testExamWithNullCourse() {
        
        int id = 2;
        String title = "Final";
        Instant dateTime = Instant.parse("2025-11-17T14:00:00Z");
        double coefficient = 3.0;

        
        assertThrows(NullPointerException.class, () -> new Exam(id, title, null, dateTime, coefficient),
                "Creating an exam with a null course must throw a NullPointerException");
    }

    @Test
    void testExamWithNegativeCoefficient() {
       
        int id = 3;
        String title = "Quiz";
        Instant dateTime = Instant.parse("2025-11-18T09:00:00Z");
        double negativeCoefficient = -1.0;

        
        assertThrows(IllegalArgumentException.class, () -> new Exam(id, title, course, dateTime, negativeCoefficient),
                "Creating an exam with a negative coefficient must throw an IllegalArgumentException");
    }

    @Test
    void testExamWithNullTitle() {
        
        int id = 4;
        String nullTitle = null;
        Instant dateTime = Instant.parse("2025-11-19T10:00:00Z");
        double coefficient = 1.5;

        
        assertThrows(NullPointerException.class, () -> new Exam(id, nullTitle, course, dateTime, coefficient),
                "Creating an exam with a null title must throw a NullPointerException");
    }
}
