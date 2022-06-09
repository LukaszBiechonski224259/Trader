package com.app.Trader.repository;

import com.app.Trader.model.Client;

public class ClientDaoFactory {
    public DAO<Client> createFileClientDao(String fileName){
        return new ClientDao(fileName);
    }
}
