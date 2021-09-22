package com.test.atm.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> bankAccount = new HashMap<String, Customer>();
    private static Bank bank;

    public static Bank getInstance() {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public Map<String, Customer> getBankAccount() {
        return bankAccount;
    }

}
