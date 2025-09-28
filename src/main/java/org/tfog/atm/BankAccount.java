package org.tfog.atm;

public class BankAccount {
    private String id;
    private String name;
    private double balance;

    public BankAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(String id, String name) {
        this(id, name, 0);
    }

    public String getId() {
      return id;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid amount to deposit.");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid amount to withdraw.");
        }
        if (amount > this.balance) {
            throw new Exception("Could not withdraw more than the current balance.");
        }

        this.balance -= amount;
    }

}
