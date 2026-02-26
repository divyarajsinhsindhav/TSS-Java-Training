package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.repository.InMemoryCustomerRepository;
import com.foodapp.repository.UserRepository;

public class CustomerService {
    private UserRepository userRepository;

    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer findCustomerById(int id) {
        return userRepository.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " does not exist"));
    }

    public Customer findCustomerByEmail(String email) {
        return userRepository.getCustomers().stream().filter(customer -> customer.getEmail().equals(email.trim())).findFirst().orElseThrow(() -> new IllegalArgumentException("Customer with email " + email + " does not exist"));
    }

    public boolean checkCustomerExistByEmail(String email) {
        return userRepository.getCustomers().stream().anyMatch(customer -> customer.getEmail().equals(email.trim()));
    }
}
