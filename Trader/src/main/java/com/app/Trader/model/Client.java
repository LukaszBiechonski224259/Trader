package com.app.Trader.model;

import com.app.Trader.model.enums.Currency;
import com.app.Trader.model.enums.TransactionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Client implements User {

    private final UUID clientID = UUID.randomUUID();
    private final Bill billEUR = new Bill(Currency.EUR);
    private final Bill billPLN = new Bill(Currency.PLN);
    private final Bill billUSD = new Bill(Currency.USD);


    public Client() {}


    // Client Getters
    public UUID getClientID() {
        return clientID;
    }

    public Bill getBillEUR() {
        return billEUR;
    }

    public Bill getBillPLN() {
        return billPLN;
    }

    public Bill getBillUSD() {
        return billUSD;
    }


    @Override
    public List<String> getTransactionsHistory(Currency currency) {
        return Collections.singletonList("Bill in EUR: " +
                billEUR.getAllTransactions() + "\n" +
                "Bill in PLN: " +
                billPLN.getAllTransactions() + "\n" +
                "Bill in USD: " +
                billUSD.getAllTransactions() +
                '\n');
    }

    @Override
    public List<String> getDetailedHistory(Currency currency) {
        List <String> list = new ArrayList<>();
        if(billEUR.getCurrency().equals(currency)){
            for(Transaction t : billEUR.getAllTransactions()){
                list.add(t.toString());
            }
            return list;
        }

        else if(billPLN.getCurrency().equals(currency)){
            for(Transaction t : billPLN.getAllTransactions()){
                list.add(t.toString());
            }
            return list;
        }
        else
        {
            for(Transaction t : billUSD.getAllTransactions()){
                list.add(t.toString());
            }
            return list;
        }

    }

    @Override
    public List<String> getDetailedHistory(String dateFrom, String dateTo) {
        //date saved as string in format "yyyy-MM-dd"
        List<String> list = new ArrayList<>();
        for(int i = 0; i < billEUR.getAllTransactions().size(); i++) {
            if(billEUR.getAllTransactions().get(i).getStrDate().equals(dateFrom)) {
                for(int j = i; j < billEUR.getAllTransactions().size(); j ++) {
                    if(!billEUR.getAllTransactions().get(j).getStrDate().equals(dateTo))
                         list.add(String.valueOf((billEUR.getAllTransactions().get(j))));

                }

            }
        }
        for(int i = 0; i < billPLN.getAllTransactions().size(); i++) {
            if(billPLN.getAllTransactions().get(i).getStrDate().equals(dateFrom)) {
                for(int j = i; j < billPLN.getAllTransactions().size(); j ++) {
                    if(!billPLN.getAllTransactions().get(j).getStrDate().equals(dateTo))
                        list.add(String.valueOf((billPLN.getAllTransactions().get(j))));

                }

            }
        }
        for(int i = 0; i < billUSD.getAllTransactions().size(); i++) {
            if(billUSD.getAllTransactions().get(i).getStrDate().equals(dateFrom)) {
                for(int j = i; j < billUSD.getAllTransactions().size(); j ++) {
                    if(!billUSD.getAllTransactions().get(j).getStrDate().equals(dateTo))
                        list.add(String.valueOf((billUSD.getAllTransactions().get(j))));

                }

            }
        }
        return list;
    }

    @Override
    public List<String> getDetailedHistory(TransactionType type) {
        List<String> list = new ArrayList<>();
        for(Transaction t : billEUR.getAllTransactions()){
                if(t.getTransactionType().equals(type)) {
                    list.add(t.toString());
                }
            }
        for(Transaction t : billPLN.getAllTransactions()){
            if(t.getTransactionType().equals(type)) {
                list.add(t.toString());
            }
        }
        for(Transaction t : billUSD.getAllTransactions()){
            if(t.getTransactionType().equals(type)) {
                list.add(t.toString());
            }
        }

            return list;
    }

    @Override
    public float getAccountBalance(Currency curr) {
        if(billEUR.getCurrency().equals(curr))
            return billEUR.getAmountOfMoney();

        else if(billPLN.getCurrency().equals(curr))
            return billPLN.getAmountOfMoney();

        else
            return billUSD.getAmountOfMoney();

    }

    @Override
    public String toString() {
        return "Client{" +
                "\n clientID=" + clientID +
                ",\n billEUR=" + billEUR +
                ",\n billPLN=" + billPLN +
                ",\n billUSD=" + billUSD +
                '}' + '\n';
    }
}
