package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customerRepository.addCustomer(customer);
    }

    public Customer findCustomerById(int id) {
        return customerRepository.getCustomers()
                .stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " does not exist"));
    }

    public Customer findCustomerByEmail(String email) {
        return customerRepository.getCustomers()
                .stream()
                .filter(customer -> customer.getEmail().equals(email.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Customer with email " + email + " does not exist"));
    }
}
