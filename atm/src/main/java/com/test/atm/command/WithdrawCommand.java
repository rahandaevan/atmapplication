package com.test.atm.command;

import com.test.atm.domain.AtmMachine;

import java.math.BigDecimal;

public class WithdrawCommand implements CommandInterfaces{
    AtmMachine atmMachine;

    public WithdrawCommand(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void execute(String[] args) {
        if (args.length !=1) {
            System.out.println("INVALID ARGUMENT");
        } else {
            atmMachine.withDrawal(new BigDecimal(args[0]));
            System.out.println("Welcome "+atmMachine.getCustomer().getName());
            System.out.println("Your Balance is "+atmMachine.getCustomer().getBalance());
            System.out.println("\n");
        }

    }
}
