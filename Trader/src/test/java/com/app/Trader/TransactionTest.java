package com.app.Trader;

import com.app.Trader.model.Client;
import com.app.Trader.model.Transaction;
import com.app.Trader.model.enums.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import static com.app.Trader.model.enums.Currency.EUR;
import static com.app.Trader.model.enums.Currency.PLN;

public class TransactionTest {

@Test
    public void readFromJSONTest(){
    Transaction transaction = new Transaction(PLN, 100);
    Assertions.assertEquals(transaction.getExchangeRateFromJSON(PLN, PLN), 1);
}

@Test
    public void moneyOperationsTest(){
    Client client = new Client();
    Client client2 = new Client();
    Transaction transaction = new Transaction(EUR, 100);
    transaction.makePayment(client.getBillPLN());
    Assertions.assertEquals(client.getBillPLN().getAllTransactions().size(),1);
    Assertions.assertEquals(client.getAccountBalance(PLN),459);
    transaction.makePaycheck(client.getBillPLN());
    Assertions.assertEquals(client.getBillPLN().getAllTransactions().size(),2);
    Assertions.assertEquals(client.getAccountBalance(PLN),0);
    transaction.makePayment(client.getBillEUR());
    Assertions.assertEquals(client.getBillEUR().getAllTransactions().size(),1);
    Assertions.assertEquals(client.getAccountBalance(EUR),100);
    transaction.makeTransfer(client.getBillEUR(),client2.getBillEUR());
    Assertions.assertEquals(client.getBillPLN().getAllTransactions().size(),2);
    Assertions.assertEquals(client.getAccountBalance(EUR),0);
    Assertions.assertEquals(client2.getAccountBalance(EUR),100);
}
}
