package com.app.Trader.repository;

public interface DAO<T> extends AutoCloseable{
    T read();
    void write (T obj);
}
