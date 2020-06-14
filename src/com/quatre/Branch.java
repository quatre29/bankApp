package com.quatre;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers ;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(ArrayList<Customer> customer) {
        this.customers = customer;
    }

    public String getBranchName() {
        return name;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer findCustomer(String customerName) {
        for (int i=0; i<customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public void viewTransactions(String customerName) {
        Customer customer = findCustomer(customerName);
        System.out.println(customerName + "'s balance is " + customer.getBalance());
        System.out.println("All " + customerName + "'s transactions: ");
        for (int i=0; i<customer.getTransactions().size(); i++) {
            System.out.println(customer.getTransactions().get(i));
        }
    }


}
