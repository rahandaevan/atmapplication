package com.test.atm.command;

import com.test.atm.domain.AtmMachine;

import java.math.BigDecimal;

public class LogoutCommand implements CommandInterfaces {
    AtmMachine atmMachine;

    public LogoutCommand(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void execute(String args[]) {

        System.out.println("thanks" + atmMachine.getCustomer());
        atmMachine.logout();

    }
}
