package com.app.Trader.model;

import java.util.List;

public interface MoneyOperation <T>{

    public void makePayment( T object);

    public void makePaycheck( T obcject);
    public void makeTransfer( T object1, T object2);

}
