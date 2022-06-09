package com.app.Trader;

import com.app.Trader.model.Client;
import com.app.Trader.model.enums.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class ClientTest {

    @Test
    public void checkIfIDIsUnique(){
        Client client1 = new Client();
        Client client2 = new Client();
        Assertions.assertNotEquals(client1.getClientID(), client2.getClientID());
    }

    @Test
    public void checkInitialBill(){
        Client client1 = new Client();
        Assertions.assertEquals(client1.getBillEUR().getAmountOfMoney(),0);
        Assertions.assertEquals(client1.getBillPLN().getAmountOfMoney(),0);
        Assertions.assertEquals(client1.getBillUSD().getAmountOfMoney(),0);
    }

    @Test
    public void initialAccountccountBalanceCheck(){
        Client client1 = new Client();
        Assertions.assertEquals(client1.getAccountBalance(Currency.EUR), 0);
        Assertions.assertEquals(client1.getAccountBalance(Currency.PLN), 0);
        Assertions.assertEquals(client1.getAccountBalance(Currency.USD), 0);
    }

}
