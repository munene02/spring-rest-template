package com.martinmunene.springresttemplatedemo.client;

import com.martinmunene.springresttemplatedemo.model.BeerDTO;
import com.martinmunene.springresttemplatedemo.model.BeerDTOPageImpl;
import com.martinmunene.springresttemplatedemo.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * @author Martin Munene
 */
@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";
    private static final String GET_BEER_BY_ID_PATH = "/api/v1/beer/{beerId}";

    @Override
    public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize)  {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if(beerName!=null){
            uriComponentsBuilder.queryParam("beerName", beerName);
        }

        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        //System.out.println(response.getBody());
        return response.getBody();
    }

    @Override
    public Page<BeerDTO> listBeers() {
        return this.listBeers(null, null, null, null, null);
    }


    @Override
    public BeerDTO getBeerById(UUID id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return restTemplate.getForObject(GET_BEER_BY_ID_PATH, BeerDTO.class, id);
    }
}
