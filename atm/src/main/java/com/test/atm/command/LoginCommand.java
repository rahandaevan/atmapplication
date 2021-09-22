package com.test.atm.command;

import com.test.atm.domain.AtmMachine;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LoginCommand implements CommandInterfaces {
    AtmMachine atmMachine;

    public LoginCommand(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void execute(String args[]) {
        if (args.length !=1) {
            System.out.println("INVALID ARGUMENT");
        } else {
            atmMachine.login(args[0]);
            System.out.println("Welcome "+atmMachine.getCustomer().getName());
            System.out.println("Your Balance is "+atmMachine.getCustomer().getBalance());
            System.out.println("\n");

        }
    }
}
