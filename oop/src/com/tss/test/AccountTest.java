package com.tss.test;

import com.tss.Exception.MinimumBalanceException;
import com.tss.Exception.NegativeNumberException;
import com.tss.model.Account;
import com.tss.model.CurrentAccount;
import com.tss.model.SavingAccount;
import com.tss.model.Transaction;
import com.tss.utils.InputValidation;

import java.util.*;

import static com.tss.test.StudentMain.scanner;

public class AccountTest {

    private static List<Account> accountList = new ArrayList<>();
    private static final int MAX_ACCOUNT = 5;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Display all accounts");
            System.out.println("7. Display account");
            System.out.println("8. Delete Account");
            System.out.println("9. Display Transactions");
            System.out.println("10. Exit");

            int choice = InputValidation.readInt("Enter choice: ", 1, 10);

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
                    displayAllAccounts();
                    break;

                case 7:
                    displayAccount();
                    break;

                case 8:
                    deleteAccount();
                    break;

                case 9:
                    displayTransactions();
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Enter valid choice");
            }
        }
    }

    public static void createAccount() {

        if (accountList.size() >= MAX_ACCOUNT) {
            System.out.println("Account limit reached!");
            return;
        }

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int type = InputValidation.readInt("Select account type: ", 1, 2);
        scanner.nextLine();
        String name = InputValidation.readName("Enter account holder name: ");

        Account account;
        int accountNumber = genrateUniqueAccountNumber();
        if (type == 1) {
            double balance = InputValidation.readDouble("Enter initial balance: ", 1);
            double offerRate = InputValidation.readDouble("Enter offer rate: ", 1);

            try {
                account = new SavingAccount(name, balance, accountNumber, offerRate);
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else if (type == 2) {
            double balance = InputValidation.readDouble("Enter initial balance: ", 1);
            try {
                account = new CurrentAccount(name, balance, accountNumber);
            } catch(NegativeNumberException | MinimumBalanceException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else {
            System.out.println("Invalid account type");
            return;
        }

        accountList.add(account);

        System.out.println("Account created successfully");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public static Account findAccountByAccountNumber(int accountNo) {
        if (accountNo < 0) {
            throw new NegativeNumberException(accountNo);
        }
        for (int i = 0; i < accountList.size(); i++) {
            Account tempAccount = accountList.get(i);
            if (tempAccount.getAccountNumber() == accountNo) {
                return tempAccount;
            }
        }
        return null;
    }

    public static void performDeposit() {
        int accountNo = InputValidation.readInt("Enter account number: ", 0);
        Account account = findAccountByAccountNumber(accountNo);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        double amount = InputValidation.readDouble("Enter amount to deposit: ", 0);
        account.deposit(amount);
    }

    public static void performWithdraw() {
        int accNo = InputValidation.readInt("Enter account number: ", 0);
        Account account = findAccountByAccountNumber(accNo);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        double amount = InputValidation.readDouble("Enter amount to withdraw: ", 0);
        try {
            account.withdraw(amount);
        } catch (NegativeNumberException | MinimumBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showBalance() {
        int accNo = InputValidation.readInt("Enter account number: ", 0);
        Account account = findAccountByAccountNumber(accNo);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Current Balance: " + account.getBalance());
    }

    public static void transferMoney() {
        displayAccountNumbers();
        System.out.println();
        int senderAcc = InputValidation.readInt("Enter sender account number: ", 0);
        int receiverAcc = InputValidation.readInt("Enter receiver account number: ", 0);

        Account sender = findAccountByAccountNumber(senderAcc);
        Account receiver = findAccountByAccountNumber(receiverAcc);

        if (sender == receiver) {
            System.out.println("Self transfer service is not available");
            return;
        }

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number");
            return;
        }
        double amount = InputValidation.readDouble("Enter amount to transfer: ", 1);
        sender.transferMoney(receiver, amount);
    }

    public static void displayAccountNumbers() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        accountList.forEach(account -> {
            System.out.println("\nAccount Number: " + account.getAccountNumber() + "\n" +
                    "Account Type: " + account.getAccountType());
        });
    }

    public static void displayAccount() {
        int accountNumber = InputValidation.readInt("Enter valid account number: ", 0);
        Account tempAccount = findAccountByAccountNumber(accountNumber);
        if (tempAccount == null) {
            System.out.println("No such account found. Try again.");
            return;
        }
        System.out.println(tempAccount);
    }

    public static void displayAllAccounts() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        accountList.forEach(account -> {
            System.out.println("--------------------------------------");
            System.out.println(
                    "Holder Name: " + account.getName() + "\n" +
                    "Account Type: " + account.getAccountType() + "\n" +
                    "Balance: " + account.getBalance());
        } );
    }

    public static void displayTransactions() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts is found");
            return;
        }

        int accountNumber = InputValidation.readInt("Enter valid account number: ", 0);

        List<Transaction> source = getTransactionsByAccountNumber(accountNumber);

        if (source == null || source.isEmpty()) {
            System.out.println("No such transactions found!");
            return;
        }

        List<Transaction> transactions = new ArrayList<>(source);


        System.out.println(
                "+------+----------+----------+----------------------+----------------------+------------------------+-----------------------+");
        System.out.printf(
                "| %-4s | %-8s | %-8s | %-20s | %-20s | %-22s | %-21s |%n",
                "ID", "Amount", "Type", "Sender", "Receiver", "Balance Before", "Balance After");
        System.out.println(
                "+------+----------+----------+----------------------+----------------------+------------------------+-----------------------+");

        transactions.forEach(transaction -> {
            System.out.printf(
                    "| %-4d | %-8.2f | %-8s | %-20d | %-20d | %-22.2f | %-21.2f |%n",
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getType(),
                    transaction.getSenderAccountNumber(),
                    transaction.getReceiverAccountNumber(),
                    transaction.getBalanceBeforeTransaction(),
                    transaction.getBalanceAfterTransaction()
            );
        });

        System.out.println(
                "+------+----------+----------+----------------------+----------------------+------------------------+-----------------------+");

    }

    public static List<Transaction> getTransactionsByAccountNumber(int accountNumber) {
        Account account = findAccountByAccountNumber(accountNumber);

        if (account == null || account.getTransactionList() == null) {
            System.out.println("No transactions found!");
            return null;
        }

        return new ArrayList<>(account.getTransactionList());
    }

    public static void deleteAccount() {
        int accountNumber = InputValidation.readInt("Enter valid account number: ", 0);

        if (findAccountByAccountNumber(accountNumber) == null) {
            System.out.println("No such account found. Try again.");
            return;
        }

        deleteAccountById(accountNumber);
    }

    public static void deleteAccountById(int accountId) {
        accountList.removeIf(account ->
            account.getAccountNumber() == accountId
        );
    }

    public static int genrateUniqueAccountNumber() {
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = random.nextInt(10000, 99999) + 1;
        } while (findAccountByAccountNumber(randomNumber) != null);
        return randomNumber;
    }

}
