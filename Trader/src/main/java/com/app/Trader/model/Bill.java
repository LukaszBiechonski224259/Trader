package com.app.Trader.model;

import com.app.Trader.model.enums.Currency;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bill {

    private Currency currency;
    private  float amountOfMoney = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    public Bill(Currency currency) {
        this.currency = currency;
    }

    //Bill Getters
    public Currency getCurrency() {
        return currency;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }


    //Bill Setters
    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    //Bill Functions
    public boolean addToList(@NotNull Transaction newObject) {
        return transactions.add(newObject);
    }


    @Override
    public String toString() {
        return "Bill{" +
                "\n currency=" + currency +
                ",\n amountOfMoney=" + amountOfMoney +
                ",\n transactions=" + transactions +
                '}';
    }
}
