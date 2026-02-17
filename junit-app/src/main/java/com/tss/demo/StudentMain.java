package com.tss.demo;

public class StudentMain {
    private  StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public double getPercentage() {
        return studentService.getTotalMarks() / studentService.getTotalStudents();
    }
}
