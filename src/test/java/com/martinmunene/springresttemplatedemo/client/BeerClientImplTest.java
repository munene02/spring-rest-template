package com.martinmunene.springresttemplatedemo.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Martin Munene
 */
@SpringBootTest
class BeerClientImplTest {
    @Autowired
    BeerClientImpl beerClient;

    @Test
    void listBeersNoName() {
        beerClient.listBeers(null);
    }

    @Test
    void listBeers() {
        beerClient.listBeers("ALE");
    }
}