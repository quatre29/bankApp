package com.quatre;

import java.util.ArrayList;

public class Customer {
    //CRAZY COLORS IN CUSTOMER CLASS
    private String name;
    private ArrayList<Double> transactions;
    private double balance;
    private String branchName;

    public Customer(String name, double balance, String branchName) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<Double>();
        this.branchName = branchName;
    }

    public String getCustomerName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions (Double transaction) {
        this.transactions.add(transaction);
    }

    public double getBalance() {
        return balance;
    }

    public String getBranchName() {
        return branchName;
    }

    public void addTransaction(double transaction, boolean topUp) {
        this.transactions.add(transaction);
        if (topUp) {
            this.balance += transaction;
            System.out.println("+" + transaction);
        } else {
            this.balance -= transaction;
            System.out.println("-" + transaction);
        }

    }





}
