package com.alfimenkov.finalproject.dto;

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
public class HotTourDto extends AbstractTourDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty (value = "price")
    private UserPriceDto price;

    @JsonProperty(value = "isHot")
    private Boolean isHot;

    @JsonProperty(value = "quantity")
    private int quantity;

    @JsonProperty(value = "categories")
    private Set<TourCategoryDto> categories;
}
