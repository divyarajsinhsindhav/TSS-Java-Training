package com.foodapp.repository;

import com.foodapp.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void addCustomer(Customer customer);

    void removeCustomer(Customer customer);

    List<Customer> getCustomers();
}