package com.example.demo;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface AccountFactory {
    Account createAccount();
    List<Account> createAccountsFromCSV(String csvFilePath);
}

class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        Account account = new Account();
        account.setAccountType("Savings");
        return account;
    }

    @Override
    public List<Account> createAccountsFromCSV(String csvFilePath) {
        // This factory doesn't support reading from CSV
        return null;
    }
}

class CurrentAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        Account account = new Account();
        account.setAccountType("Current");
        return account;
    }

    @Override
    public List<Account> createAccountsFromCSV(String csvFilePath) {
        // This factory doesn't support reading from CSV
        return null;
    }
}

class AccountClient {
    public static void main(String[] args) {
        // Create a factory to read accounts from CSV
        AccountFactory factory = new AccountFactory() {
            @Override
            public Account createAccount() {
                // This method is not used for CSV reading
                return null;
            }

            @Override
            public List<Account> createAccountsFromCSV(String csvFilePath) {
                List<Account> accounts = new ArrayList<>();
                try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
                    List<String[]> lines = reader.readAll();
                    // Skip header line
                    for (int i = 1; i < lines.size(); i++) {
                        String[] data = lines.get(i);
                        if (data.length == 4) {
                            Account account = new Account();
                            account.setName(data[0]);
                            account.setCNIC(data[1]);
                            account.setAccountNumber(data[2]);
                            account.setAccountType(data[3]);
                            accounts.add(account);
                        } else {
                            System.err.println("Invalid data format in CSV file at line " + (i + 1));
                        }
                    }
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
                return accounts;
            }
        };

        List<Account> accounts = factory.createAccountsFromCSV("C:/Users/Usha K/Desktop/6THSEM/OOAD/demo/src/main/resources/account.csv");

        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                generateEStatement(account);
            }
        } else {
            System.err.println("Failed to create accounts from CSV file.");
        }
    }

    public static void generateEStatement(Account account) {
        AccountView view = new AccountView();
        AccountController controller = new AccountController(account, view);

        // Simulate user interaction
        User user = new User("Alice");
        controller.setUser(user);
        controller.generateEStatement();

        // Simulate accountant interaction
        Accountant accountant = new Accountant("Bob");
        controller.setAccountant(accountant);
        controller.generateEStatement();
    }
}