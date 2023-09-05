package com.nissan.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Menu:");
            System.out.println("1. Customer Menu");
            System.out.println("2. Administrator Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerMenu(bank, scanner);
                    break;
                case 2:
                    adminMenu(bank, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
		// TODO Auto-generated method stub
		
		/*Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Menu:");
            System.out.println("1. Customer Menu");
            System.out.println("2. Administrator Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerMenu(bank, scanner);
                    break;
                case 2:
                    adminMenu(bank, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }*/


    private static void customerMenu(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        Customer customer = bank.findCustomer(accountNumber);

        if (customer == null) {
            System.out.println("Account number not found..!!!");
            return;
        }

        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Show Balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    customer.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    customer.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Balance: " + customer.getBalance());
                    break;
                case 4:
                    System.out.print("Enter Destination Account Number: ");
                    int toAccountNumber = scanner.nextInt();
                    System.out.print("Enter Transfer Amount: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transferMoney(customer, toAccountNumber, transferAmount);
                    break;
                case 5:
                    System.out.println("Exiting Customer Menu.");
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu(Bank bank, Scanner scanner) {
        while (true) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer Details");
            System.out.println("3. Delete Customer");
            System.out.println("4. Display All Customers");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(bank, scanner);
                    break;
                case 2:
                    updateCustomerDetails(bank, scanner);
                    break;
                case 3:
                    deleteCustomer(bank, scanner);
                    break;
                case 4:
                    bank.displayAllCustomers();
                    break;
                case 5:
                    System.out.println("Exiting Administrator Menu.");
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   /* private static void addCustomer(Bank bank, Scanner scanner) {
        do {
            System.out.print("Customer Name (max 30 characters): ");
            String customerName = scanner.next();
            if (customerName.length() > 30) {
                System.out.println("Customer Name should not exceed 30 characters.");
                continue;
            }

            System.out.print("Account Type (Savings/Current): ");
            String accountType = scanner.next();
            
            int accountNumber = bank.generateAccountNumber();

            /*int accountNumber;
            try {
                System.out.print("Account Number (9 digits): ");
                accountNumber = scanner.nextInt();
                if (String.valueOf(accountNumber).length() != 9) {
                    System.out.println("Account Number should be a 9-digit number.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Account Number should be numeric and have 9 digits.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            double balance;
            try {
                System.out.print("Initial Balance (numeric only): ");
                balance = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Balance should be numeric.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            double minBalance;
            try {
                System.out.print("Minimum Balance (numeric only): ");
                minBalance = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Minimum Balance should be numeric.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            long mobileNumber;
            try {
                System.out.print("Mobile Number (10 digits): ");
                mobileNumber = scanner.nextLong();
                String mobileNumberStr = String.valueOf(mobileNumber);
                if (mobileNumberStr.length() != 10) {
                    System.out.println("Mobile Number should have exactly 10 digits.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Mobile Number should be numeric and have 10 digits.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            System.out.print("Email ID: ");
            String emailId = scanner.next();

            bank.addCustomer(customerName, accountType, balance, minBalance, mobileNumber, emailId);
            break; // Break out of the loop if all validations pass
        } while (true);
    } */
    
    private static void addCustomer(Bank bank, Scanner scanner) {
        while (true) {
            System.out.print("Customer Name (max 30 characters): ");
            String customerName = scanner.next();
            if (customerName.length() > 30) {
                System.out.println("Customer Name should not exceed 30 characters.");
                continue;
            }

            System.out.print("Account Type (Savings/Current): ");
            String accountType = scanner.next();

            int accountNumber = bank.generateAccountNumber();

            double balance;
            try {
                System.out.print("Initial Balance (numeric only): ");
                balance = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Balance should be numeric.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            double minBalance;
            try {
                System.out.print("Minimum Balance (numeric only): ");
                minBalance = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Minimum Balance should be numeric.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            long mobileNumber;
            try {
                System.out.print("Mobile Number (10 digits): ");
                mobileNumber = scanner.nextLong();
                String mobileNumberStr = String.valueOf(mobileNumber);
                if (mobileNumberStr.length() != 10) {
                    System.out.println("Mobile Number should have exactly 10 digits.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Mobile Number should be numeric and have 10 digits.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            System.out.print("Email ID: ");
            String emailId = scanner.next();

            bank.addCustomer(customerName, accountType, balance, minBalance, mobileNumber, emailId);
            break; // Break out of the loop if all validations pass
        }
    }

    private static void updateCustomerDetails(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter New Mobile Number: ");
        long newMobileNumber = scanner.nextLong();
        System.out.print("Enter New Email ID: ");
        String newEmailId = scanner.next();

        bank.updateCustomerDetails(accountNumber, newMobileNumber, newEmailId);
    }

    private static void deleteCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number to delete: ");
        int accountNumber = scanner.nextInt();
        bank.deleteCustomer(accountNumber);
		
	}

}
