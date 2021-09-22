package com.test.atm.domain;

import com.test.atm.constans.MessageConstants;
import com.test.atm.exceptions.BussinessExceptions;
import com.test.atm.model.Bank;
import com.test.atm.model.Customer;

import java.math.BigDecimal;

public class BankServices implements Transaction {

    private static BankServices bankServices;
    private Bank bank = Bank.getInstance();


    public static BankServices getInstance() {
        if (bankServices == null) {
            bankServices = new BankServices();
        }
        return bankServices;
    }

    @Override
    public BigDecimal transfer(String sourceAccount, String destinationAccount, BigDecimal amount) {
        Customer sourceAcct = getCustomerByName(sourceAccount);
        if (sourceAcct.getBalance().compareTo(amount) > 0) {
            Customer destAcct = getCustomerByName(destinationAccount);
            destAcct.setBalance(destAcct.getBalance().add(amount));
            sourceAcct.setBalance(sourceAcct.getBalance().subtract(amount));
        } else {
            throw new BussinessExceptions(MessageConstants.INSUFUCIENT_FUND);
        }
        return sourceAcct.getBalance();
    }

    @Override
    public BigDecimal withdraw(String sourceAccount, BigDecimal amount) {
        Customer sourceAcct = getCustomerByName(sourceAccount);
        if (sourceAcct.getBalance().compareTo(amount) > 0) {
            sourceAcct.setBalance(sourceAcct.getBalance().subtract(amount));
        } else {
            throw new BussinessExceptions(MessageConstants.INSUFUCIENT_FUND);
        }
        return sourceAcct.getBalance();
    }

    @Override
    public BigDecimal deposit(String sourceAccount, BigDecimal amount) {
        Customer cust = getCustomerByName(sourceAccount);
        cust.setBalance(cust.getBalance().add(amount));
        return cust.getBalance();
    }

    @Override
    public Customer registerNewCustomer(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBalance(new BigDecimal(0));
        bank.getBankAccount().put(name, customer);
        return customer;
    }


    public Customer getCustomerByName(String name) {
        Customer customer = bank.getBankAccount().get(name);
        if (customer == null) {
            throw new BussinessExceptions(MessageConstants.ACCOUNT_NOT_FOUND);
        }
        return customer;
    }

    public Customer getCustomer(String name) {
        return bank.getBankAccount().get(name);
    }
}

