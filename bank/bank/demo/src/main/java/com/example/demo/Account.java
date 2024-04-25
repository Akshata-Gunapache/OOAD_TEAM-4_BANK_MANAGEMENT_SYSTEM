package com.example.demo;
class Account {
    private String name;
    private String cnic;
    private String accountNumber;
    private String accountType;

    public String getName() {
        return name;
    }

    public String getCNIC() {
        return cnic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNIC(String cnic) {
        this.cnic = cnic;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
