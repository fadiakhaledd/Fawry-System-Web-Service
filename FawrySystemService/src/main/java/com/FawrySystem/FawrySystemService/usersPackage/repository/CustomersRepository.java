package com.FawrySystem.FawrySystemService.usersPackage.repository;

import com.FawrySystem.FawrySystemService.usersPackage.models.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CustomersRepository {
    private static HashMap<String, Customer> customersEmails = new HashMap<>();
    private static HashMap<String, Customer> customersUsernames = new HashMap<>();

    public Boolean checkCustomerExistence (String username, String email) {
        return customersUsernames.containsKey(username) && customersEmails.containsKey(email);
    }

    public void addCustomer (Customer customer) {
        customersEmails.put(customer.getEmail(), customer);
        customersUsernames.put(customer.getUsername(), customer);
    }

    static public Customer getCustomerByEmail(String  email) {
        if (customersEmails.containsKey(email)) {
            return customersEmails.get(email);
        }
        return null;
    }

    static public Customer getCustomerByUsername(String username) {
        if (customersUsernames.containsKey(username)) {
            return customersUsernames.get(username);
        }
        return null;
    }
}