import com.test.atm.command.CommandFactory;
import com.test.atm.domain.AtmMachine;
import com.test.atm.ui.Client;

import java.io.IOException;

public class AtmApplication {

    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();
        AtmMachine atmMachine = new AtmMachine();
        commandFactory.initCommand(atmMachine);
        commandFactory.getListCommand();
        Client client = new Client(commandFactory);
        try {
            client.handleInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
