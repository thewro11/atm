package org.tfog.atm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public final class BankCsvDataSource {
    private static final String csvFilename = "src/main/resources/bank-account-data.csv";
    private static final String csvFieldSeparator = ",";

    private static Map<String, BankAccount> bankAccounts = new HashMap<>();

    private BankCsvDataSource() { }

    public static BankCsvDataSource getInstance() {
        return new BankCsvDataSource();
    }

    public Map<String, BankAccount> loadBankData() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilename));

        // skip first line (header)
        reader.readLine();

        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(csvFieldSeparator);
            String id = data[0];
            String name = data[1];
            double balance = Double.parseDouble(data[2]);

            bankAccounts.put(data[0], new BankAccount(id, name, balance));
        }

        reader.close();

        return bankAccounts;
    }

}
