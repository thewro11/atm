package org.tfog.atm;

import java.util.Map;

public class BankDataSource {
    private Map<String, BankAccount> bankAccounts;

    public BankDataSource() throws Exception {
        this.bankAccounts = BankCsvDataSource.getInstance().loadBankData();
    }

    public void add(BankAccount bankAccount) {
        this.bankAccounts.put(bankAccount.getId(), bankAccount);
    }

    public BankAccount get(String bankAccountId) {
        return this.bankAccounts.get(bankAccountId);
    }

}
