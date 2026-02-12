package com.tss.test;

import com.tss.model.Account;
import com.tss.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(101, "Rahul", 5000));
        accounts.add(new Account(102, "Smit", 12000));
        accounts.add(new Account(103, "Max", 3000));
        accounts.add(new Account(104, "Tanmay", 15000));
        accounts.add(new Account(105, "Divyarajsinh", 8000));

        System.out.println("Show account with minimum balance: ");
        showAccountWithMinimumBalance(accounts);

        System.out.println("Show account with maximum balance: ");
        showAccountWithMaximumBalance(accounts);

        System.out.println("Show name greater than 6 characters: ");
        nameFilterOnLength(accounts, 6);

        System.out.println("Total balance: ");
        getTotalBalance(accounts);
    }

    public static void showAccountWithMinimumBalance(List<Account> accounts) {
        accounts.stream()
                .min(Comparator.comparingDouble(Account::getBalance))
                .ifPresent(Account::display);
    }

    public static void showAccountWithMaximumBalance(List<Account> accounts) {
        accounts.stream()
                .max(Comparator.comparingDouble(Account::getBalance))
                .ifPresent(Account::display);
    }

    public static void nameFilterOnLength(List<Account> accounts, int length) {
        accounts.stream()
                .filter(account -> account.getName().length() > length)
                .forEach(Account::display);
    }

    public static void getTotalBalance(List<Account> accounts) {
        double totalBalance = accounts.stream()
                .map(account -> account.getBalance())
                        .reduce(0.0, (a, b) -> a+b);
        System.out.println("Total Balance: " + totalBalance);
    }
}
