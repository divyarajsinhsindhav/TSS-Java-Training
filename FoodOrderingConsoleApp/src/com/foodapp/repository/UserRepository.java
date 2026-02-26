package com.foodapp.repository;

import com.foodapp.model.Admin;
import com.foodapp.model.Customer;
import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(Customer customer);

    void removeUser(Customer customer);

    List<User> getUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

    List<DeliveryPartner> getDeliveryPartners();

    List<Admin> getAdmins();

    List<Customer> getCustomers();

    Customer getCustomerById(int id);

    Admin getAdminById(int id);

    DeliveryPartner getDeliveryPartnerById(int id);
}
