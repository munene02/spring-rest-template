package com.martinmunene.springresttemplatedemo.client;

import com.martinmunene.springresttemplatedemo.model.BeerDTO;
import org.springframework.data.domain.Page;

/**
 * @author Martin Munene
 */
public interface BeerClient {
    Page<BeerDTO> listBeers();
}
