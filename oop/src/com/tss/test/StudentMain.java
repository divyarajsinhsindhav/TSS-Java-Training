package com.tss.test;

import com.tss.model.Course;
import com.tss.model.Student;

import java.util.Random;
import java.util.Scanner;

public class StudentMain {
    static Scanner scanner = new Scanner(System.in);
    static final int MAX_STUDENT = 10;
    static final int MAX_COURSE = 5;
    static int countOfStudent = 0;
    static int countOfCourse = 0;
    static Student[] students;
    static Course[] courses;

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        int userInputForNumberOfStudent = scanner.nextInt();
        students = new Student[userInputForNumberOfStudent];
        System.out.print("\nEnter number of course: ");
        int userInputForNumberOfCourse = scanner.nextInt();
        courses = new Course[userInputForNumberOfCourse];
        int studentId;
        Student student;

        while(true) {
            System.out.println("\n1. Add new Student" +
                    "\n2. Add new course" +
                    "\n3. Display single student" +
                    "\n4. Display all student" +
                    "\n5. Pay Fees" +
                    "\n6. Pending Fees" +
                    "\n7. Display all course" +
                    "\n8. Update Course" +
                    "\n9. Exit");
            int userChoice;
            do {
                System.out.println("Enter your choice");
                userChoice = scanner.nextInt();
                if (userChoice < 0 || userChoice > 9) {
                    System.out.println("Please enter valid choice");
                }
            } while(userChoice < 0 || userChoice > 9);

            switch (userChoice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    System.out.println("Which student data you want to see? ");
                    studentId = scanner.nextInt();
                    student = getStudentById(studentId);
                    if (student == null) {
                        System.out.println("No student found");
                        break;
                    }
                    System.out.println(student);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    if (countOfStudent == 0) {
                        System.out.println("0 students available");
                        break;
                    }

                    System.out.println("For which student you want to pay fees? ");
                    studentId = scanner.nextInt();

                    student = getStudentById(studentId);
                    if (student == null) {
                        System.out.println("No student with given id is available");
                        break;
                    }

                    System.out.println("Pending fees: " + student.getPenddingFees());
                    System.out.println("How much fees you want to pay? ");
                    double feesAmount = scanner.nextDouble();
                    if (student.payFees(feesAmount)) {
                        System.out.println("Remaining Pending Fees: " + student.getPenddingFees());
                    }
                    break;
                case 6:
                    if (countOfStudent == 0) {
                        System.out.println("0 students available");
                        break;
                    }

                    System.out.println("For which student you want to see pending fees? ");
                    studentId = scanner.nextInt();

                    student = getStudentById(studentId);
                    if (student == null) {
                        System.out.println("No student with given id is available");
                        break;
                    }

                    System.out.println("Pending fees: " + student.getPenddingFees());
                    break;
                case 7:
                    displayAllCourses();
                    break;
                case 8:
                    if (countOfCourse == 0) {
                        System.out.println("No courses available to update.");
                        return;
                    }

                    System.out.print("Enter Course ID to update: ");
                    int courseId = scanner.nextInt();

                    Course course = getCourseById(courseId);

                    if (course == null) {
                        System.out.println("Course not found.");
                        return;
                    }

                    scanner.nextLine();

                    System.out.println("Current Course Details:");
                    System.out.println(course);

                    System.out.print("Enter new Course Name (press Enter to keep same): ");
                    String name = scanner.nextLine();
                    if (!name.isBlank()) {
                        course.setName(name);
                    }

                    System.out.print("Enter new Course Fees (0 to keep same): ");
                    int fees = scanner.nextInt();
                    if (fees > 0) {
                        course.setFees(fees);
                    }

                    for (int i = 0; i < countOfStudent; i++) {
                        students[i].recalculateTotalFees();
                    }


                    System.out.print("Enter new Course Duration (0 to keep same): ");
                    int duration = scanner.nextInt();
                    if (duration > 0) {
                        course.setDuration(duration);
                    }

                    System.out.println("Course updated successfully!");
                    break;
                default:
                    System.out.println("Please enter valid choice");
            }
        }
    }

    private static void addStudent() {
        if (countOfCourse == 0) {
            System.out.println("Please first add courses.");
            return;
        }
        if (countOfStudent == students.length) {
            System.out.println("Limit exceed");
            return;
        }

        students[countOfStudent] = new Student();
        int id = generateUniqueStudentId(students, countOfStudent);
        students[countOfStudent].setId(id);
        System.out.println("Generated Student ID: " + id);

        scanner.nextLine();
        System.out.print("Enter Name: ");
        students[countOfStudent].setName(scanner.nextLine());

        System.out.println("Available Courses:");
        for (int j = 0; j < countOfCourse; j++) {
            System.out.println(courses[j].getId() + ". " + courses[j].getName());
        }

        int maxSelectableCourses = Math.min(3, countOfCourse);
        System.out.println("You can select up to " + maxSelectableCourses + " course");
        System.out.println("Enter 0 anytime to stop selecting courses");

        for (int i = 0; i < maxSelectableCourses; i++) {

            System.out.print("Enter course id (0 to stop): ");
            int courseId = scanner.nextInt();

            if (courseId == 0) {
                break;
            }

            boolean added = false;

            for (int j = 0; j < countOfCourse; j++) {
                if (courses[j].getId() == courseId) {
                    added = students[countOfStudent].addCourse(courses[j]);
                    break;
                }
            }

            if (!added) {
                System.out.println("Please select a valid or non-duplicate course.");
                i--;
            }
        }


        System.out.println("Total Fees: " + students[countOfStudent].getTotalFees());

        System.out.print("\nFees you want to pay now: ");
        double payFees = scanner.nextInt();
        students[countOfStudent].setFeesPaid(payFees);

        countOfStudent++;
    }

    private static void addCourse() {
        if (countOfCourse == MAX_COURSE) {
            System.out.println("Course limit reached!");
            return;
        }

        courses[countOfCourse] = new Course();

        int courseId = genrateUniqueCourseId(courses, countOfCourse);
        courses[countOfCourse].setId(courseId);
        System.out.println("Generated Course ID: " + courseId);


        scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        courses[countOfCourse].setName(courseName);

        System.out.print("Enter Course Fees: ");
        double courseFees = scanner.nextDouble();
        courses[countOfCourse].setFees(courseFees);

        System.out.print("Enter Course Duration: ");
        int courseDuration = scanner.nextInt();
        courses[countOfCourse].setDuration(courseDuration);

        countOfCourse++;
    }

    private static Student getStudentById(int id) {
        for (int i = 0; i < countOfStudent; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    private static Course getCourseById(int id) {
        for (int i = 0; i < countOfCourse; i++) {
            if (courses[i].getId() == id) {
                return courses[i];
            }
        }
        return null;
    }

    private static void displayAllStudents() {

        if (countOfStudent == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-30s | %-10s | %-10s |%n",
                "ID", "Name", "Courses", "Paid", "Pending");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < countOfStudent; i++) {

            Student student = students[i];

            StringBuilder courseNames = new StringBuilder();
            for (Course c : student.getCourses()) {
                if (c != null) {
                    courseNames.append(c.getName()).append(", ");
                }
            }

            System.out.printf("| %-5d | %-20s | %-30s | %-10.2f | %-10.2f |%n",
                    student.getId(),
                    student.getName(),
                    courseNames.toString(),
                    student.getFeesPaid(),
                    student.getPenddingFees()
            );
        }

        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private static void displayAllCourses() {

        if (countOfCourse == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s |%n",
                "ID", "Course Name", "Fees", "Duration");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < countOfCourse; i++) {
            Course c = courses[i];

            System.out.printf("| %-5d | %-20s | %-10.2f | %-10d |%n",
                    c.getId(),
                    c.getName(),
                    c.getFees(),
                    c.getDuration()
            );
        }

        System.out.println("---------------------------------------------------------------");
    }


    private static int generateUniqueStudentId(Student[] students, int count) {
        Random random = new Random();
        int id;
        boolean exists;

        do {
            id = random.nextInt(100) + 1;
            exists = false;

            for (int i = 0; i < count; i++) {
                if (students[i].getId() == id) {
                    exists = true;
                    break;
                }
            }
        } while (exists);

        return id;
    }

    private static int genrateUniqueCourseId(Course[] courses, int count) {
        Random random = new Random();
        int id;
        boolean exists;

        do {
            id = random.nextInt(100) + 1;
            exists = false;

            for (int i = 0; i < count; i++) {
                if (courses[i].getId() == id) {
                    exists = true;
                    break;
                }
            }
        } while (exists);

        return id;
    }
}