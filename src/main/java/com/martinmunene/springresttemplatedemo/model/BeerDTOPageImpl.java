package com.martinmunene.springresttemplatedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Martin Munene
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
public class BeerDTOPageImpl<BeerDTO> extends PageImpl<com.martinmunene.springresttemplatedemo.model.BeerDTO> {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerDTOPageImpl(@JsonProperty("content") List<com.martinmunene.springresttemplatedemo.model.BeerDTO> content,
                           @JsonProperty("page") int page,
                           @JsonProperty("size") int size,
                           @JsonProperty("totalElements") long total) {

        super(content, PageRequest.of(page,size), total);
    }

    public BeerDTOPageImpl(List<com.martinmunene.springresttemplatedemo.model.BeerDTO> content, Pageable page, long total) {
        super(content, page, total);
    }

    public BeerDTOPageImpl(List<com.martinmunene.springresttemplatedemo.model.BeerDTO> content) {
        super(content);
    }
}
