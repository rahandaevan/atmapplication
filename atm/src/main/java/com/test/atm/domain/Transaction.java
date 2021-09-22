package com.test.atm.domain;

import com.test.atm.model.Customer;

import java.math.BigDecimal;

public interface Transaction {
    public BigDecimal transfer(String sourceAccount, String destinationAccount, BigDecimal amount);

    public BigDecimal withdraw(String sourceAccount, BigDecimal amount);

    public BigDecimal deposit(String sourceAccount, BigDecimal amount);

    public Customer registerNewCustomer(String name);

    public Customer getCustomerByName(String name);

}
