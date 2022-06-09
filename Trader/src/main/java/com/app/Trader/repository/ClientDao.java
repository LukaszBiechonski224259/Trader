package com.app.Trader.repository;

import com.app.Trader.model.Client;

import java.io.*;

public class ClientDao implements DAO<Client> {

    private String fileName;

    public ClientDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Client read() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Client) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Client();
        }

    }

    @Override
    public void write(Client obj) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {

    }
}
