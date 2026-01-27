package com.tss.test;

import com.tss.model.Account;
import com.tss.model.CurrentAccount;
import com.tss.model.SavingAccount;

import java.util.Scanner;

public class AccountTest {
    private static Scanner scanner = new Scanner(System.in);
    private static Account account = null;

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    if (account != null) {
                        System.out.println("How much money want to deposit?");
                        double depositAmmount = scanner.nextDouble();
                        account.deposit(depositAmmount);
                    } else {
                        System.out.println("Create account first");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("How much money want to withdraw?");
                        double withdrawAmmount = scanner.nextDouble();
                        account.withdraw(withdrawAmmount);
                    } else {
                        System.out.println("Create account first");
                    }
                    break;

                case 4:
                    if (account != null) {
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("Create account first");
                    }
                    break;

                case 5:
                    return;
                default:
                    System.out.println("Enter a valid choice.");

            }
        }
    }

    public static void createAccount() {
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int accountType = scanner.nextInt();

        System.out.println("Enter account holder name: ");
        String name = scanner.next();


        if (accountType == 1) {
            System.out.println("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.println("Enter offer rate: ");
            double offerRate = scanner.nextDouble();
            account = new SavingAccount(name, initialBalance, offerRate);
        } else if (accountType == 2) {
            account = new CurrentAccount(name, CurrentAccount.getMINIMUM_BALANCE());
        }
        System.out.println("Account Created Successfully!");
        System.out.println("Account Number: " + account.getAccountNumber());
    }
}
