package com.app.Trader.model;

import com.app.Trader.model.enums.Currency;
import com.app.Trader.model.enums.TransactionType;
import com.app.Trader.model.exceptions.InvalidAmountException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Transaction implements MoneyOperation<Bill> {
    private TransactionType transactionType;
    private final Currency currency;
    private final float amountOfMoney;
    private String strDate;

    public Transaction(Currency currency, float amountOfMoney) {
        this.currency = currency;
        try{
            checkAmountOfMoney(amountOfMoney);
        } catch (InvalidAmountException e) {
            e.printStackTrace();
        }
        this.amountOfMoney = amountOfMoney;

    }

    //Transaction Getters
    public TransactionType getTransactionType(){
        return transactionType;
    }
    public Currency getCurrency() {

        return currency;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }


    public String getStrDate() {
        return strDate;
     }

        //Transaction Setters
    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }
    public void setTransactionType(TransactionType type){
        this.transactionType = type;
    }

    public String DateToString(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);

    }

    public float getExchangeRateFromJSON(Currency curr1, Currency curr2) {
        String data = null;
        float exchangeRate = 1;
        try {
            data = new String(Files.readAllBytes(Paths.get("src/main/resources/exchangeRate.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray(Objects.requireNonNull(data));
        for (int i = 0; i < jsonArray.length(); i++) {
           JSONObject object1 = new JSONObject(jsonArray.get(i).toString());
           if((String.valueOf(curr1).equals(object1.getString("currency 1"))) && (String.valueOf(curr2).equals(object1.getString("currency 2"))))
               exchangeRate = object1.getFloat("value");
        }
        return exchangeRate;
    }


    @Override
    public void makePayment( @NotNull Bill bill) {
        bill.setAmountOfMoney(bill.getAmountOfMoney() + (amountOfMoney * getExchangeRateFromJSON(this.getCurrency(), bill.getCurrency())));
        setStrDate(DateToString());
        setTransactionType(TransactionType.PAYMENT);
        bill.addToList(this);

    }

    @Override
    public void makePaycheck( @NotNull Bill bill) {
        bill.setAmountOfMoney(bill.getAmountOfMoney() - (amountOfMoney * getExchangeRateFromJSON(this.getCurrency(), bill.getCurrency())));
        setStrDate(DateToString());
        setTransactionType(TransactionType.PAYCHECK);
        bill.addToList(this);
    }

    @Override
    public void makeTransfer( @NotNull Bill bill1, @NotNull Bill bill2) {
        bill1.setAmountOfMoney(bill1.getAmountOfMoney() - (amountOfMoney * getExchangeRateFromJSON(this.getCurrency(), bill1.getCurrency())));
        setStrDate(DateToString());
        setTransactionType(TransactionType.TRANSFERFROM);
        bill1.addToList(this);
        bill2.setAmountOfMoney(bill2.getAmountOfMoney() + (amountOfMoney * getExchangeRateFromJSON(this.getCurrency(), bill2.getCurrency())));
        setStrDate(DateToString());
        setTransactionType(TransactionType.TRANSFERTO);
        bill2.addToList(this);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "\n transactionType=" + transactionType +
                ",\n currency=" + currency +
                ",\n amountOfMoney=" + amountOfMoney +
                ",\n Date='" + strDate + '\'' +
                '}';
    }
    static void checkAmountOfMoney(float money) throws InvalidAmountException{
        if(money <= 0) {
            throw new InvalidAmountException("\n" + "The declared amount of money must be greater than 0");
        }
    }
}
