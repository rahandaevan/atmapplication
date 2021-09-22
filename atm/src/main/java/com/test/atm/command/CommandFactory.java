package com.test.atm.command;

import com.test.atm.domain.AtmMachine;
import com.test.atm.exceptions.BussinessExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandFactory {
    private Map<String, CommandInterfaces> commands = new HashMap();

    public void initCommand(AtmMachine atmMachine) {
        commands.put("login", new LoginCommand(atmMachine));
        commands.put("deposit", new DepositCommand(atmMachine));
        commands.put("withdraw", new WithdrawCommand(atmMachine));
        commands.put("transfer", new TransferCommand(atmMachine));
        commands.put("logout", new LogoutCommand(atmMachine));
    }

    public void executeCommand(String method, String[] args) {
        try {
            if (commands.get(method) != null) {
                commands.get(method).execute(args);
            } else {
                System.out.println("Command Not Found");
                System.out.println("");
            }
        } catch (BussinessExceptions e) {
            System.out.println("ERROR  :: " + e.getMessage());
            System.out.println("");
        }
    }

    public void getListCommand (){
        List returnList = new ArrayList(commands.keySet());
        returnList.add("exit");

        System.out.println("List Command");
        for (int i = 0; i < returnList.size();i++){
            System.out.println(""+returnList.get(i));
        }

        System.out.println("\n\n");
        System.out.println("Input Your Command :: \n\n");
    }
}
