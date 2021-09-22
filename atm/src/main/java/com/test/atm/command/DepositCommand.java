package com.test.atm.command;

import com.test.atm.domain.AtmMachine;

import java.math.BigDecimal;

public class DepositCommand implements CommandInterfaces {
    AtmMachine atmMachine;

    public DepositCommand(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void execute(String args[]) {
        if (args.length !=1) {
            System.out.println("INVALID ARGUMENT");
        } else {
            atmMachine.deposit(new BigDecimal(args[0]));
            System.out.println("Thanks "+atmMachine.getCustomer().getName());
            System.out.println("Your Current Balance is "+atmMachine.getCustomer().getBalance());
            System.out.println("\n");
        }
    }
}
