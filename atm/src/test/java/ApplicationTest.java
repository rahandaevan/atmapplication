import com.test.atm.domain.AtmMachine;
import com.test.atm.domain.BankServices;
import com.test.atm.model.Customer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @Test
    public void _test_deposit() {

        BankServices bank = new BankServices();
        bank.registerNewCustomer("EVAN");
        bank.deposit("EVAN",new BigDecimal(100000));
        bank.deposit("EVAN",new BigDecimal(100000));

        Customer cust = bank.getCustomerByName("EVAN");

        assertEquals(cust.getBalance(), new BigDecimal(200000));
    }


    @Test
    public void _test_transfer() {

        BankServices bank = BankServices.getInstance();
        bank.registerNewCustomer("EVAN");
        bank.registerNewCustomer("RAHANDA");

        bank.deposit("EVAN",new BigDecimal(100000));
        bank.transfer("EVAN", "RAHANDA", new BigDecimal(40000));


        Customer evan = bank.getCustomerByName("EVAN");
        Customer rahanda = bank.getCustomerByName("RAHANDA");

        assertEquals(evan.getBalance(), new BigDecimal(60000));
        assertEquals(rahanda.getBalance(), new BigDecimal(40000));

    }


    @Test
    public void _test_transfer_atm() {

        AtmMachine atmMachine = new AtmMachine();
        atmMachine.login("Evan");
        atmMachine.deposit(new BigDecimal(10000));
        AtmMachine atmMachine1 = new AtmMachine();
        atmMachine1.login("Rahanda");
        AtmMachine atmMachine2 = new AtmMachine();
        atmMachine2.login("Randa");

        atmMachine.transferTo("Rahanda", new BigDecimal(100));

        assertEquals(BankServices.getInstance().getCustomer("Rahanda").getBalance(), new BigDecimal(100));

    }

}
