
package com.school.model.example;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GradeServiceTest {

    @Test
    void testGetExamGrade() {
        Tutor tutor = new Tutor(1, "Doe", "Jane", LocalDate.of(1980, 1, 1), "jane@example.com", "123456", "Parent");
        Student student = new Student(1, "Smith", "John", LocalDate.of(2000, 1, 1), "john@example.com", "654321", "GroupA", tutor);
        Teacher teacher = new Teacher(1, "Brown", "Bob", LocalDate.of(1970, 1, 1), "bob@example.com", "111222", "back-end");
        Course course = new Course(1, "PROG1", 5, teacher);
        Exam exam = new Exam(1, "Midterm", course, Instant.parse("2023-10-01T10:00:00Z"), 2.0);

        Grade grade = new Grade(student, exam);
        Instant t1 = Instant.parse("2023-10-02T12:00:00Z");
        grade.addChange(10.0, t1, "Initial grade");
        Instant t2 = Instant.parse("2023-10-03T12:00:00Z");
        grade.addChange(12.0, t2, "Correction");

        GradeService service = new GradeService();
        service.addExam(exam);
        service.addGrade(grade);

        assertEquals(10.0, service.getExamGrade(exam, student, t1));
        assertEquals(12.0, service.getExamGrade(exam, student, t2));

        Instant t3 = Instant.parse("2023-10-04T12:00:00Z");
        assertEquals(12.0, service.getExamGrade(exam, student, t3));

        Instant t0 = Instant.parse("2023-10-01T12:00:00Z");
        assertThrows(IllegalStateException.class, () -> service.getExamGrade(exam, student, t0));
    }

    @Test
    void testGetCourseGrade() {
        Tutor tutor = new Tutor(1, "Doe", "Jane", LocalDate.of(1980, 1, 1), "jane@example.com", "123456", "Parent");
        Student student = new Student(1, "Smith", "John", LocalDate.of(2000, 1, 1), "john@example.com", "654321", "GroupA", tutor);
        Teacher teacher = new Teacher(1, "Brown", "Bob", LocalDate.of(1970, 1, 1), "bob@example.com", "111222", "back-end");
        Course course = new Course(1, "PROG2", 5, teacher);

        Exam exam1 = new Exam(1, "Exam1", course, Instant.parse("2023-10-01T10:00:00Z"), 2.0);
        Exam exam2 = new Exam(2, "Exam2", course, Instant.parse("2023-11-01T10:00:00Z"), 3.0);

        Grade grade1 = new Grade(student, exam1);
        grade1.addChange(10.0, Instant.parse("2023-10-02T12:00:00Z"), "Initial");

        Grade grade2 = new Grade(student, exam2);
        grade2.addChange(15.0, Instant.parse("2023-11-02T12:00:00Z"), "Initial");

        GradeService service = new GradeService();
        service.addExam(exam1);
        service.addExam(exam2);
        service.addGrade(grade1);
        service.addGrade(grade2);

        Instant t = Instant.parse("2023-12-01T00:00:00Z");

        assertEquals(13.0, service.getCourseGrade(course, student, t));
    }
}


