package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.repository.InMemoryCustomerRepository;

public class CustomerService {
    private InMemoryCustomerRepository inMemoryCustomerRepository;

    public CustomerService(InMemoryCustomerRepository inMemoryCustomerRepository) {
        this.inMemoryCustomerRepository = inMemoryCustomerRepository;
    }

    public void createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        inMemoryCustomerRepository.addCustomer(customer);
    }

    public Customer findCustomerById(int id) {
        return inMemoryCustomerRepository.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " does not exist"));
    }

    public Customer findCustomerByEmail(String email) {
        return inMemoryCustomerRepository.getCustomers().stream().filter(customer -> customer.getEmail().equals(email.trim())).findFirst().orElseThrow(() -> new IllegalArgumentException("Customer with email " + email + " does not exist"));
    }

    public boolean checkCustomerExistByEmail(String email) {
        return inMemoryCustomerRepository.getCustomers().stream().anyMatch(customer -> customer.getEmail().equals(email.trim()));
    }
}
