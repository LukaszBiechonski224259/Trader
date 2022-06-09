package com.app.Trader;

import com.app.Trader.repository.ClientDaoFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ClientDaoFactoryTest {
    private ClientDaoFactory factory = new ClientDaoFactory();
    @Test
    public void getFileDaoTest(){
        Assertions.assertNotNull(factory.createFileClientDao("clientList"));

    }
}
