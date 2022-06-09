package com.app.Trader.model;

import com.app.Trader.model.enums.Currency;
import com.app.Trader.model.enums.TransactionType;

import java.util.List;

public interface User  {
    public List<String> getTransactionsHistory(Currency curr);
    public List<String> getDetailedHistory(Currency curr);
    public List<String> getDetailedHistory(String dateFrom, String dateTo);
    public List<String> getDetailedHistory(TransactionType type);
    public float getAccountBalance(Currency curr);

}
