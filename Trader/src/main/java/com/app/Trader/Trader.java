package com.app.Trader;

import com.app.Trader.model.Client;
import com.app.Trader.model.Transaction;

import static com.app.Trader.model.enums.Currency.USD;

public class Trader {
    public static void main(String[] args) {
        Client client = new Client();
        Transaction transaction = new Transaction(USD, 150);
        System.out.printf(client.toString());
        transaction.makePayment(client.getBillUSD());
        System.out.printf(String.valueOf(client.getDetailedHistory(USD)));



        System.out.println("\n"+"Program failed successfully!");
    }
}
