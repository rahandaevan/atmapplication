package com.test.atm.domain;

import com.test.atm.model.Customer;

import java.math.BigDecimal;

public class AtmMachine {
    private Customer customer;
    private BankServices bankServices = BankServices.getInstance();

    public void login(String name) {
        customer = bankServices.getCustomer(name);
        if (customer == null) {
            customer = bankServices.registerNewCustomer(name);
        }
        this.customer = customer;
    }


    public void transferTo(String destinationAccount, BigDecimal amount) {
        if (customer != null) {
            getCustomer().setBalance(bankServices.transfer(customer.getName(), destinationAccount, amount));
        }
    }

    public void withDrawal(BigDecimal amount) {
        if (customer != null) {
            getCustomer().setBalance(bankServices.withdraw(customer.getName(), amount));
        }
    }

    public void deposit(BigDecimal amount) {
        if (customer != null) {
            getCustomer().setBalance(bankServices.deposit(customer.getName(), amount));
        }
    }

    public void logout() {
        customer =null;
    }

    public Customer getCustomer() {
        return customer;
    }



}
