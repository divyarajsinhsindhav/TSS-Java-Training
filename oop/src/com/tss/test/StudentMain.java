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
        int numberOfStudent;
        do {
            System.out.print("Enter number of students: ");
            numberOfStudent = scanner.nextInt();
            if (numberOfStudent > 0 && numberOfStudent <= MAX_STUDENT) {
                break;
            }
            System.out.println("Must be greater than 0 or less than 10");
        } while (numberOfStudent <= 0 || numberOfStudent > MAX_STUDENT);

        students = new Student[numberOfStudent];

        int numberOfCourse;
        do{
            System.out.print("\nEnter number of course: ");
            numberOfCourse = scanner.nextInt();
            if (numberOfCourse > 0 && numberOfCourse <= MAX_COURSE) {
                break;
            }
            System.out.println("Must be greater than 0 or less than 5");
        } while (numberOfCourse <= 0 || numberOfCourse > MAX_COURSE);

        courses = new Course[numberOfCourse];



        while(true) {
            System.out.println("\n1. Add new Student" +
                    "\n2. Add new course" +
                    "\n3. Display single student" +
                    "\n4. Display all students" +
                    "\n5. Pay Fees" +
                    "\n6. Pending Fees" +
                    "\n7. Display all courses" +
                    "\n8. Assign course to student" +
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
                    displaySingleStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    payFees();
                    break;
                case 6:
                    pendingFees();
                    break;
                case 7:
                    displayAllCourses();
                    break;
                case 8:
                    assignCourse();
                    break;
                case 9:
                    return;
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

//        System.out.print("\nFees you want to pay now: ");
//        double payFees = scanner.nextInt();
//        students[countOfStudent].setFeesPaid(payFees);

        countOfStudent++;
    }

    private static void addCourse() {
        if (countOfCourse == courses.length) {
            System.out.println("Course limit reached!");
            return;
        }

        courses[countOfCourse] = new Course();

        int courseId = genrateUniqueCourseId(courses, countOfCourse);
        courses[countOfCourse].setId(courseId);
        System.out.println("Generated Course ID: " + courseId);

        while (true) {
            scanner.nextLine();
            System.out.print("Enter Course Name: ");
            String courseName = scanner.nextLine();
            if(getCourseByName(courseName) != null) {
                System.out.println("Course with " + courseName + " already available.");
                continue;
            }
            courses[countOfCourse].setName(courseName);
            break;
        }

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

    private static Course getCourseByName(String courseName) {
        String tempCourseName;
        for (int i = 0; i < countOfCourse; i++) {
            tempCourseName = courses[i].getName().trim().replaceAll(" ", "").toLowerCase();
            if (tempCourseName.equals(courseName.trim().replaceAll(" ", "").toLowerCase())) {
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
        System.out.printf("| %-5s | %-20s | %-30s | %-10s | %-10s | %-10s |%n",
                "ID", "Name", "Courses", "Paid", "Pending", "Total Fees");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < countOfStudent; i++) {

            Student student = students[i];

            StringBuilder courseNames = new StringBuilder();
            for (Course c : student.getCourses()) {
                if (c != null) {
                    courseNames.append(c.getName()).append(", ");
                }
            }

            System.out.printf("| %-5d | %-20s | %-30s | %-10.2f | %-10.2f | %-10.2f |%n",
                    student.getId(),
                    student.getName(),
                    courseNames.toString(),
                    student.getFeesPaid(),
                    student.getPenddingFees(),
                    student.getTotalFees()
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

    private static void assignCourse() {

        if (countOfStudent == 0) {
            System.out.println("No students available.");
            return;
        }

        if (countOfCourse == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        Student student = getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Course[] studentCourses = student.getCourses();
        int assignedCount = 0;
        for (Course c : studentCourses) {
            if (c != null) assignedCount++;
        }

        if (assignedCount == 3) {
            System.out.println("Student already has maximum 3 courses.");
            return;
        }

        System.out.println("Available Courses:");
        for (int i = 0; i < countOfCourse; i++) {
            System.out.println(courses[i].getId() + ". " + courses[i].getName());
        }

        int remainingSlots = 3 - assignedCount;
        System.out.println("You can assign up to " + remainingSlots + " more course");
        System.out.println("Enter 0 to stop assigning");

        for (int i = 0; i < remainingSlots; i++) {
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();

            if (courseId == 0) {
                break;
            }

            Course course = getCourseById(courseId);
            if (course == null) {
                System.out.println("Invalid course ID.");
                i--;
                continue;
            }

            boolean added = student.addCourse(course);
            if (!added) {
                i--;
            }
        }

        System.out.println("Courses assigned successfully.");
        System.out.println("Updated Total Fees: " + student.getTotalFees());
    }

    private static void payFees() {
        if (countOfStudent == 0) {
            System.out.println("0 students available");
            return;
        }

        System.out.println("For which student you want to pay fees? ");
        int studentId = scanner.nextInt();

        Student student = getStudentById(studentId);
        if (student == null) {
            System.out.println("No student with given id is available");
            return;
        }

        Course[] studentEnrolledCourse = student.getCourses();

        if (studentEnrolledCourse.length == 0) {
            System.out.println("Student is not enrolled in any course.");
            return;
        }

        for (Course value : studentEnrolledCourse) {
            if (value == null) break;
            System.out.println(value.getId() + ". " + value.getName() + " (Pending fees: " + value.getPenddingFees() + ")");
        }

        System.out.println("For which course you want to pay fees? ");
        int courseId = scanner.nextInt();
        System.out.println("How much fees you want to pay? ");
        double feesAmount = scanner.nextDouble();

        if (student.payFees(feesAmount, studentEnrolledCourse, courseId)) {
            System.out.println("Remaining Pending Fees: " + student.getPenddingFees());
        }
    }

    private static void pendingFees() {
        if (countOfStudent == 0) {
            System.out.println("0 students available");
            return;
        }

        System.out.println("For which student you want to see pending fees? ");
        int studentId = scanner.nextInt();

        Student student = getStudentById(studentId);
        if (student == null) {
            System.out.println("No student with given id is available");
            return;
        }

        Course[] studentEnrolledCourse = student.getCourses();

        if (studentEnrolledCourse.length == 0) {
            System.out.println("Student is not enrolled in any course.");
            return;
        }

        for (Course value : studentEnrolledCourse) {
            if (value == null) break;
            System.out.println(value.getId() + ". " + value.getName() + " (Pending fees: " + value.getPenddingFees() + ")");
        }

    }

    private static void displaySingleStudent() {
        System.out.println("Which student data you want to see? ");
        int studentId = scanner.nextInt();
        Student student = getStudentById(studentId);
        if (student == null) {
            System.out.println("No student found");
            return;
        }
        System.out.println(student);
    }
}