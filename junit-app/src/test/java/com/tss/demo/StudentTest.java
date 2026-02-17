package com.tss.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    StudentService studentService;
    StudentMain student;

   @BeforeEach
   void setUp() {
       studentService = Mockito.mock(StudentService.class);
       student = new StudentMain();
       student.setStudentService(studentService);
   }

    @Test
    void getPercentage() {
       Mockito.when(studentService.getTotalMarks()).thenReturn(100);
       Mockito.when(studentService.getTotalStudents()).thenReturn(50);

       assertEquals(2, student.getPercentage());
    }
}