package com.app.Trader;

import com.app.Trader.model.Bill;
import com.app.Trader.model.enums.Currency;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BillTest {
    @Test
    public void makeBillTest(){
        Bill bill = new Bill(Currency.USD);
        Assertions.assertEquals(bill.getCurrency(), Currency.USD);
        Assertions.assertEquals(bill.getAmountOfMoney(), 0);
        bill.setAmountOfMoney(350);
        Assertions.assertEquals(bill.getAmountOfMoney(),350);
    }
}
