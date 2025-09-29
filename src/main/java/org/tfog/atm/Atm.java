package org.tfog.atm;

import java.util.Scanner;

public final class Atm {
    
    private BankAccount currentBankAccount;
    private BankDataSource bankDataSource;

    public Atm() throws Exception {
        this.bankDataSource = new BankDataSource();
    }

    public void login(String bankAccountId) throws Exception {
        this.currentBankAccount = this.bankDataSource.get(bankAccountId);
        if (this.currentBankAccount == null) {
            throw new Exception("Bank account id #" + bankAccountId + " not found.");
        }

        System.out.printf("Successfully logged in. Welcome, %s!\n", this.currentBankAccount.getName());
    }

    public void deposit(double amount) throws Exception {
        this.currentBankAccount.deposit(amount);
        System.out.printf(
            "Successfully deposited %.2f into %s (%s). Current balance: %.2f\n",
            amount,
            this.currentBankAccount.getId(),
            this.currentBankAccount.getName(),
            this.currentBankAccount.getBalance()
        );
    }

    public void withdraw(double amount) throws Exception {
        this.currentBankAccount.withdraw(amount);
        System.out.printf(
            "Successfully withdrew %.2f into %s (%s). Current balance: %.2f\n",
            amount,
            this.currentBankAccount.getId(),
            this.currentBankAccount.getName(),
            this.currentBankAccount.getBalance()
        );
    }

    public static void main(String[] args) {
        System.out.println("Starting an ATM...");
        Atm atm = null;
        Scanner scanner = new Scanner(System.in);
        try {
            atm = new Atm();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.print("Please enter your bank account id: ");
            String bankAccountId = scanner.nextLine();

            if (bankAccountId.equals("shutdown")) {
                System.out.println("Shutting down the ATM...");
                break;
            }

            System.out.println("Querying bank account...");
            try {
                atm.login(bankAccountId);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                continue;
            }

            String transaction = null;
            while (true) {
                System.out.println("Select your transaction");
                System.out.println("[1] Deposit");
                System.out.println("[2] Withdraw");
                System.out.println("[9] Cancel");
                System.out.print(": ");
                transaction = scanner.nextLine();

                if (transaction.matches("1|2|9")) {
                    break;
                }
                System.err.println("Invalid transaction entered. Please select again.");
            }

            if (transaction.equals("9")) {
                atm.currentBankAccount = null;
                System.out.println("Cancel the transaction. Thank you and goodbye.\n");
                continue;
            }

            String transactionType = null;
            switch (transaction) {
                case "1": transactionType = "deposit"; break;
                case "2": transactionType = "withdraw"; break;
            }

            Double amount = null;
            while (true) {
                try {
                    System.out.printf(
                        "Enter amount to %s or 'c' to cancel (Current balance: %.2f): ",
                        transactionType,
                        atm.currentBankAccount.getBalance()
                    );
                    String line = scanner.nextLine();
                    if (line.equals("c")) {
                        System.out.println("Transaction canceled.");
                        break;
                    }
                    amount = Double.parseDouble(line);
                    switch (transaction) {
                        case "1": atm.currentBankAccount.deposit(amount); break;
                        case "2": atm.currentBankAccount.withdraw(amount); break;
                    }

                    System.out.println("New balance: " + atm.currentBankAccount.getBalance());
                    break;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    System.err.println("Please enter the amount again.");
                }
            }

            System.out.println("Thank you for using our ATM! Goodbye.\n");
        }

        scanner.close();
        System.out.println("Shut down the ATM completed!");
    }

}
