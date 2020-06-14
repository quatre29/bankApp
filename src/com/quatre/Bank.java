package com.quatre;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Branch> getBranches(){
        return branches;
    }

    public void addBranch(String name) {
        if (findBranch(name) == null) {
            this.branches.add(new Branch(name));
            System.out.println("Branch has been added to the bank.");
        } else {
            System.out.println("Branch already in the system.");
        }

    }

    public Branch findBranch(String branchName){
        for (int i=0; i<branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchName().equals(branchName)){
                return branch;
            }
        } return null;

    }

    public void viewBranches(){
        for (int i=0; i<branches.size(); i++) {
            System.out.println(i+1 + "." + branches.get(i).getBranchName());
        }
    }

    public void viewCustomers(String branchName) {
        Branch branch = findBranch(branchName);
        for (int i=0; i<branch.getCustomers().size(); i++) {
            System.out.println(i+1 + "." + branch.getCustomers().get(i).getCustomerName() +
                    " " + branch.getCustomers().get(i).getBalance() + " " +
                    branch.getCustomers().get(i).getBranchName());
        }
    }


}
