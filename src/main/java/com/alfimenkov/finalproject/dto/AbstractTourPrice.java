package com.alfimenkov.finalproject.dto;


import lombok.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractTourPrice {

    @JsonProperty(value = "price")
    private double price;
}
