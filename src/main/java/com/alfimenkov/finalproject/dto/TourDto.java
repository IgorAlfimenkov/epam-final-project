package com.alfimenkov.finalproject.dto;

import com.alfimenkov.finalproject.entity.Price;
import lombok.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Set;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class TourDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    /*@JsonProperty(value = "price")
    private AbstractTourPrice price;*/

    /*@JsonProperty(value = "price")
    private PriceDto price;*/


    @JsonProperty(value = "quantity")
    private int quantity;

    @JsonProperty(value = "categories")
    private Set<TourCategoryDto> categories;

}
