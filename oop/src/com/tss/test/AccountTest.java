package com.tss.test;

import com.tss.model.Account;
import com.tss.model.CurrentAccount;
import com.tss.model.SavingAccount;

import java.util.Scanner;

public class AccountTest {

    private static Scanner scanner = new Scanner(System.in);
    private static Account[] accounts = new Account[5];
    private static int count = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    performDeposit();
                    break;

                case 3:
                    performWithdraw();
                    break;

                case 4:
                    showBalance();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    return;

                default:
                    System.out.println("Enter valid choice");
            }
        }
    }

    public static void createAccount() {

        if (count >= accounts.length) {
            System.out.println("Account limit reached!");
            return;
        }

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Select account type: ");
        int type = scanner.nextInt();

        System.out.print("Enter account holder name: ");
        String name = scanner.next();

        Account account = null;

        if (type == 1) {
            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();

            System.out.print("Enter offer rate: ");
            double offerRate = scanner.nextDouble();

            account = new SavingAccount(name, balance, offerRate);

        } else if (type == 2) {
            account = new CurrentAccount(name, CurrentAccount.getMINIMUM_BALANCE());
        } else {
            System.out.println("Invalid account type");
            return;
        }

        accounts[count++] = account;

        System.out.println("Account created successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public static Account findAccountByAccountNumber(int accountNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNo) {
                return accounts[i];
            }
        }
        return null;
    }


    public static void performDeposit() {
        System.out.print("Enter account number: ");
        int accountNo = scanner.nextInt();

        Account account = findAccountByAccountNumber(accountNo);

        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void performWithdraw() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();

        Account account = findAccountByAccountNumber(accNo);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void showBalance() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();

        Account account = findAccountByAccountNumber(accNo);

        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }

    public static void transferMoney() {
        System.out.print("Enter sender account number: ");
        int senderAcc = scanner.nextInt();

        System.out.print("Enter receiver account number: ");
        int receiverAcc = scanner.nextInt();

        Account sender = findAccountByAccountNumber(senderAcc);
        Account receiver = findAccountByAccountNumber(receiverAcc);

        if (sender != null && receiver != null) {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            sender.transferMoney(receiver, amount);
        } else {
            System.out.println("Invalid account number");
        }
    }
}
