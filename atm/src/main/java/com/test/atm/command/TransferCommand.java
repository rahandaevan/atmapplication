package com.test.atm.command;

import com.test.atm.domain.AtmMachine;

import java.math.BigDecimal;

public class TransferCommand implements CommandInterfaces {
    AtmMachine atmMachine;

    public TransferCommand(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void execute(String args[]) {
        if (args.length !=2) {
            System.out.println("INVALID ARGUMENT");
        } else {
            atmMachine.transferTo(args[0],new BigDecimal(args[1]));
            System.out.println("Welcome "+atmMachine.getCustomer().getName());
            System.out.println("Your Balance is "+atmMachine.getCustomer().getBalance());
            System.out.println("\n");

        }
    }
}
