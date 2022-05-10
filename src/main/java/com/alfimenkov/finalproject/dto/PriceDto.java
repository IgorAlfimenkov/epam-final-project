package com.alfimenkov.finalproject.dto;

import lombok.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@JsonAutoDetect
@AllArgsConstructor
@ToString
public  class PriceDto {

    public PriceDto(){

    }

    @JsonProperty(value = "basic_price")
    private Double basic_price;

    @JsonProperty(value = "vip_price")
    private Double vip_price;

    @JsonProperty(value = "hot_price")
    private Double hot_price;
}
