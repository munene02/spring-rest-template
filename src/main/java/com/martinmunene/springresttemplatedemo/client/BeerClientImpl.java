package com.martinmunene.springresttemplatedemo.client;

import com.martinmunene.springresttemplatedemo.model.BeerDTO;
import com.martinmunene.springresttemplatedemo.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Martin Munene
 */
@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity( GET_BEER_PATH, BeerDTOPageImpl.class);

        //System.out.println(response.getBody());
        return response.getBody();
    }
}
