package com.martinmunene.springresttemplatedemo.client;

import com.martinmunene.springresttemplatedemo.model.BeerDTO;
import com.martinmunene.springresttemplatedemo.model.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * @author Martin Munene
 */
public interface BeerClient {
    Page<BeerDTO> listBeers();
    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    BeerDTO getBeerById(UUID id);

    BeerDTO createBeer(BeerDTO beerDTO);
}
