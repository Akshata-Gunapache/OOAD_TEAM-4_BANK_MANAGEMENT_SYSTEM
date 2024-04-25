package com.example.demo;
class AccountView {
    public void display(String name, String cnic, String accountNumber, String accountType) {
        System.out.println("Account Details:");
        System.out.println("Name: " + name);
        System.out.println("CNIC: " + cnic);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
    }
}