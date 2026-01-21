package com.tss.model;

public class Student {
    private int id;
    private String name;
    private Course[] courses = new Course[3];
    private double feesPaid;
    private double totalFees;

    public Student() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(Course[] courses) {
        this.courses = courses;
        calculateTotalFee();
    }

    public Course[] getCourses() {
        return courses;
    }

    private void calculateTotalFee() {
        totalFees = 0;
        for (Course c: courses) {
            totalFees += c.getFees();
        }
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getPenddingFees() {
        return this.totalFees - this.feesPaid;
    }

    public boolean payFees(double amount, Course[] course, int courseId) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }

        for (int i = 0; i < course.length; i++) {
            if (courses[i] != null && courses[i].getId() == courseId) {
                if (amount > courses[i].getPenddingFees()) {
                    System.out.println("Amount is greater than pending fees.");
                    return false;
                }
                courses[i].setPaidFees(courses[i].getPaidFees()+amount);
                this.feesPaid = this.feesPaid + amount;
                return true;
            }
        }

        return false;
    }

    public boolean addCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null && courses[i].getId() == course.getId()) {
                System.out.println("Course already added to student.");
                return false;
            }
        }

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                totalFees += course.getFees(); // update total fees
                return true;
            }
        }

        System.out.println("Student course limit reached.");
        return false;
    }

    public void recalculateTotalFees() {
        totalFees = 0;
        for (Course c : courses) {
            if (c != null) {
                totalFees += c.getFees();
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder courseDetails = new StringBuilder();

        for (Course c : courses) {
            if (c != null) {
                courseDetails.append(c.getName())
                        .append(" (Fee: ")
                        .append(c.getFees())
                        .append(")\n");
            }
        }

        return "Student ID: " + id +
                "\nStudent Name: " + name +
                "\nStudent Courses:\n" + courseDetails +
                "\nFees Paid: " + feesPaid +
                "\nTotal Fees: " + totalFees;
    }

}
