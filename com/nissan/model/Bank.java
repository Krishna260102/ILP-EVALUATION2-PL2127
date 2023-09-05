package com.nissan.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	
	
	List<Customer> customers = new ArrayList<>();

    // Add a new customer
    public void addCustomer(String customerName, String accountType, double balance,
                            double minBalance, long mobileNumber, String emailId) {
        int accountNumber = generateAccountNumber();
        int atmPin = generateAtmPin();
        Customer customer = new Customer(accountNumber, customerName, accountType,
                                          balance, minBalance, mobileNumber, emailId, atmPin);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    // Update customer details
    public void updateCustomerDetails(int accountNumber, long newMobileNumber, String newEmailId) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber() == accountNumber) {
                customer.setMobileNumber(newMobileNumber);
                customer.setEmailId(newEmailId);
                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Account number not found..!!!");
    }

    // Delete a customer
    public void deleteCustomer(int accountNumber) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getAccountNumber() == accountNumber) {
                iterator.remove();
                System.out.println("Customer deleted successfully.");
                return;
            }
        }
        System.out.println("Account number not found..!!!");
    }

    // Display list of all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("List of all customers:");
            for (Customer customer : customers) {
                System.out.println("Account Number: " + customer.getAccountNumber());
                System.out.println("Customer Name: " + customer.getCustomerName());
                System.out.println("Account Type: " + customer.getAccountType());
                System.out.println("Balance: " + customer.getBalance());
                System.out.println("Minimum Balance: " + customer.getMinBalance());
                System.out.println("Mobile Number: " + customer.getMobileNumber());
                System.out.println("Email ID: " + customer.getEmailId());
                System.out.println("ATM Pin: " + customer.getAtmPin());
                System.out.println();
            }
        }
    }

    // Display customer details by account number
    public void displayCustomerDetails(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber() == accountNumber) {
                System.out.println("Account Number: " + customer.getAccountNumber());
                System.out.println("Customer Name: " + customer.getCustomerName());
                System.out.println("Account Type: " + customer.getAccountType());
                System.out.println("Balance: " + customer.getBalance());
                System.out.println("Minimum Balance: " + customer.getMinBalance());
                System.out.println("Mobile Number: " + customer.getMobileNumber());
                System.out.println("Email ID: " + customer.getEmailId());
                System.out.println("ATM Pin: " + customer.getAtmPin());
                return;
            }
        }
        System.out.println("Account number not found..!!!");
    }

    public int generateAccountNumber() {
        Random random = new Random();
       // int newAccountNumber;

        while (true) {
            int newAccountNumber = 100000000 + random.nextInt(900000000); // Generate a 9-digit number

            // Check if the generated account number already exists
            boolean exists = customers.stream()
                    .anyMatch(customer -> customer.getAccountNumber() == newAccountNumber);

            if (!exists) {
                return newAccountNumber;
            }
        }
    }
    

    private int generateAtmPin() {
        // Implement logic to generate a unique 4-digit ATM pin
        return customers.size() + 1000;
    }
    
 // Transfer money from one customer to another
    public void transferMoney(Customer fromCustomer, int toAccountNumber, double amount) {
        Customer toCustomer = findCustomer(toAccountNumber);

        if (toCustomer != null) {
            fromCustomer.transfer(this, toCustomer.getAccountNumber(), amount);
        } else {
            System.out.println("Destination account number not found..!!!");
        }
    }

    // Find a customer by account number
    public Customer findCustomer(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber() == accountNumber) {
                return customer;
            }
        }
        return null;
    }
}

