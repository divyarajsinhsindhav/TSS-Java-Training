package com.foodapp.repository;

import com.foodapp.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
}
