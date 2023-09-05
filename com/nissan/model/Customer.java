package com.nissan.model;

import java.util.Scanner;

public class Customer {
	
	private String customerName;
    private String accountType;
    private double balance;
    private double minBalance;
    private long mobileNumber;
    private String emailId;
    private int atmPin;

    public Customer(int accountNumber, String customerName, String accountType,
                    double balance, double minBalance, long mobileNumber, String emailId, int atmPin) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.minBalance = minBalance;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.atmPin = atmPin;
    }
    
    private int accountNumber;
    public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



    // Setters for Mobile Number and Email ID
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 50000) {
            System.out.print("Enter PAN Card number for deposits > 50k: ");
            String panCard = new Scanner(System.in).next();
            // Perform PAN Card validation here if necessary
        }

        this.balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        double availableBalance = balance - minBalance;

        if (amount > availableBalance) {
            System.out.println("Insufficient funds..!!!");
        } else {
            if (amount > 50000) {
                System.out.print("Enter PAN Card number for withdrawals > 50k: ");
                String panCard = new Scanner(System.in).next();
                // Perform PAN Card validation here if necessary
            }

            this.balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Get the account balance
    public double getBalance() {
        return balance;
    }

    // Transfer money to another account
    public void transfer(Bank bank, int toAccountNumber, double amount) {
        double availableBalance = balance - minBalance;

        if (amount > availableBalance) {
            System.out.println("Insufficient funds..!!!");
        } else {
            if (amount > 50000) {
                System.out.print("Enter PAN Card number for transfers > 50k: ");
                String panCard = new Scanner(System.in).next();
                // Perform PAN Card validation here if necessary
            }

            for (Customer customer : bank.customers) {
                if (customer.getAccountNumber() == toAccountNumber) {
                    this.balance -= amount;
                    customer.balance += amount;
                    System.out.println("Transferred Amount Successfully.");
                    return;
                }
            }
            System.out.println("Destination account number not found..!!!");
        }
    }

}
