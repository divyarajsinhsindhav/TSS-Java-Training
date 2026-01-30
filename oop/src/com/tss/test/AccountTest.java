package com.tss.test;

import com.tss.Exception.MinimumBalanceException;
import com.tss.Exception.NegativeNumberException;
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

            if (choice < 0) {
                throw new NegativeNumberException(choice);
            }

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

            try {
                account = new SavingAccount(name, balance, offerRate);
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else if (type == 2) {
            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();
            try {
                account = new CurrentAccount(name, balance);
            } catch(NegativeNumberException | MinimumBalanceException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else {
            System.out.println("Invalid account type");
            return;
        }

        accounts[count++] = account;

        System.out.println("Account created successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public static Account findAccountByAccountNumber(int accountNo) {
        if (accountNo < 0) {
            throw new NegativeNumberException(accountNo);
        }
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
        if (accountNo < 0) {
            throw new NegativeNumberException(accountNo);
        }
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
            try {
                account.withdraw(amount);
            } catch (NegativeNumberException | MinimumBalanceException e) {
                System.out.println(e.getMessage());
            }
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

        if (sender == receiver) {
            System.out.println("Self transfer service is not available");
            return;
        }

        if (sender != null && receiver != null) {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            sender.transferMoney(receiver, amount);
        } else {
            System.out.println("Invalid account number");
        }
    }
}
