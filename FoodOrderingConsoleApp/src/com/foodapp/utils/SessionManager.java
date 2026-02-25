package com.foodapp.utils;

import com.foodapp.model.Customer;

public class SessionManager {

    private Customer currentCustomer;

    public void login(Customer customer) {
        currentCustomer = customer;
    }

    public void logout() {
        currentCustomer = null;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public boolean isLoggedIn() {
        return currentCustomer != null;
    }
}
