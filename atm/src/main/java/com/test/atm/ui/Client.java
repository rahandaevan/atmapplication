package com.test.atm.ui;

import com.test.atm.command.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Client {
    private CommandFactory commandFactory;


    public Client(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;

    }

    public void handleInput() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String inputLine = inputReader.readLine();
                if (inputLine == null) {
                    break;
                }

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) {
                    continue;
                }

                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                processInputLine(inputLine);
            }
        } finally {
            inputReader.close();
        }
    }


    private void processInputLine(String inputLine) {
        String[] inputChunks = inputLine.split(" ");

        String command = inputChunks[0];
        String[] params = Arrays.copyOfRange(inputChunks, 1, inputChunks.length);

        commandFactory.executeCommand(command, params);
    }
}
