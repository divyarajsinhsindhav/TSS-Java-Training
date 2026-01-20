package com.tss.test;

import com.tss.model.Student;

import java.util.Scanner;

public class StudentTest {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Student student1 = new Student();
//        while(true) {
//            System.out.print("Enter Student ID: ");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//            if (student1.setId(id)) break;
//        }
//
//        System.out.print("\nEnter Student Name: ");
//        String name = scanner.nextLine();
//        student1.setName(name);
//
//        System.out.print("\nEnter Student Course: ");
//        String course = scanner.nextLine();
//        student1.setCourse(course);
//
//        System.out.print("\nEnter fees currently paid: ");
//        double feesPaid = scanner.nextDouble();
//        student1.setFeesPaid(feesPaid);
//
//        System.out.print("\nEnter total fees: ");
//        double totalFees = scanner.nextDouble();
//        student1.setTotalFees(totalFees);
//
//        while(true) {
//            System.out.println("======================================");
//            System.out.println("1. Display Student Profile");
//            System.out.println("2. Pay Fees");
//            System.out.println("3. View Pending Fees");
//            System.out.println("4. Update Course");
//            System.out.println("0. exit");
//            System.out.println("Enter your choice: ");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println(student1);
//                    break;
//                case 2:
//                    System.out.println("Pending fees: " + student1.getPenddingFees());
//                    while(true) {
//                        System.out.println("Enter amount you want to paid: ");
//                        double amount = scanner.nextDouble();
//                        if (student1.payFees(amount)) break;
//                    }
//                    break;
//                case 3:
//                    System.out.println("Pending fees: " + student1.getPenddingFees());
//                    break;
//                case 4:
//                    System.out.println("Enter course name: ");
//                    scanner.nextLine();
//                    String updatedCourse = scanner.nextLine();
//                    student1.setCourse(updatedCourse);
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Enter valid choice");
//            }
//        }
//    }
}
