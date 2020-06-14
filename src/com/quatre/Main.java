package com.quatre;

import java.util.Scanner;

public class Main {
    // COMMENT TEST
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Barclays");
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        System.out.println("Welcome to " + bank.getName() + " bank.");
        printInstructions();

        while (!quit) {
            System.out.println();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    //Add branch.
                    addBranch();
                    break;
                case 2:
                    //Add customer
                    addCustomer();
                    break;
                case 3:
                    //Move customer to a new branch.
//                    moveCustomer();

                    break;
                case 4:
                    //View customer transactions + balance
//                    viewCustomerTransaction();
                    break;
                case 5:
                    //Add customer transaction
                    addCustomerTransaction();
                    break;
                case 6:
                    printBranches();
                    break;
                case 7:
                    //print customers
                    printCustomers();
                    break;
                case 8:
                    printInstructions();
                    break;

            }
        }
    }

    public static void printInstructions() {
        System.out.println("0 - Quit app.\n" +
                            "1 - Add branch.\n" +
                            "2 - Add customer.\n" +
                            "3 - Move customer to a new branch.\n" +
                            "4 - View customer transaction\n" +
                            "5 - Add customer transaction\n" +
                            "6 - View branches.\n" +
                            "7 - View Customers.\n" +
                            "8 - Print Instructions.");

    }

    public static void addBranch() {
        System.out.print("Enter new branch name: ");
        String newBranch = scanner.nextLine();
        bank.addBranch(newBranch);

    }

    public static void addCustomer() {
        System.out.print("Enter name of the branch for your customer: ");
        String branchName = scanner.nextLine();
        Branch tmp1 = bank.findBranch(branchName);
        if (tmp1 != null) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Insert current balance: ");
            double balance = scanner.nextDouble();


            Branch branch = bank.findBranch(branchName);
            Customer newCustomer = new Customer(customerName, balance, branchName);
            branch.addCustomer(newCustomer);
            newCustomer.setTransactions(balance);
            System.out.println("Customer " + customerName + " has been added to the " + branchName + " branch.");
        } else {
            System.out.println("Branch does not exist");
        }



    }

    public static void printCustomers() {
        System.out.print("Enter name of the customer's branch: ");
        String customerBranch = scanner.nextLine();
        Branch branch = bank.findBranch(customerBranch);
        if (branch != null) {
            bank.viewCustomers(customerBranch);
            System.out.print("Do you want to see customer's transactions?\n" +
                    "1 for YES or 2 for NO:  ");

            boolean quit = false;
            int choice = 0;
            while (!quit) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter name of the customer to see transactions list: ");
                        String customerName = scanner.nextLine();
                        Customer customer = branch.findCustomer(customerName);
                        if (customer != null) {
                            branch.viewTransactions(customerName);
                        } else {
                            System.out.println("Customer not in the list.");
                        }
                        break;
                    case 2:
                        System.out.println("back to the main menu...");
                        break;
                    default:
                        System.out.println("Option does not exist.");
                        break;
                }
                quit = true;
            }
        } else {
            System.out.println("Branch does not exist.");
        }
    }

    public static void printBranches(){
        bank.viewBranches();
    }

    public static void addCustomerTransaction() {
        System.out.print("Enter name of the customer's branch: ");
        String branchName = scanner.nextLine();
        Branch branch = bank.findBranch(branchName);
        if (branch != null) {
            System.out.print("Enter name of the customer: ");
            String customerName = scanner.nextLine();
            Customer customer = branch.findCustomer(customerName);
            if (customer != null) {
                System.out.println("TEST TRUE");
                boolean quit = false;
                int choice = 0;
                boolean topUp = false;
                double sum = 0;
                System.out.println("--> to top up press 1.\n" +
                        "--> to transfer press 2." );

                while (!quit) {
                    System.out.print("Enter choice: ");
                    choice = scanner.nextInt();
                    switch(choice){
                        case 1:
                            topUp = true;
                            System.out.print("Enter amount: ");
                            sum += scanner.nextDouble();
                            System.out.println("You have topped up your account with " + sum);
                            break;
                        case 2:
                            topUp = false;
                            System.out.print("Enter amount: ");
                            sum += scanner.nextDouble();
                            System.out.println("You have transferred " + sum + " from your account");
                            break;
                    }
                    quit = true;
                }

                customer.addTransaction(sum, topUp);

            } else {
                System.out.println("Customer not found.");
            }
        } else {
            System.out.println("Branch not found.");
        }

    }

    public  static void viewCustomerTransactions(String customerName){


    }
}
