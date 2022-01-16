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
public class VipPriceDto extends PriceDto{

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "vip_price")
    private Double vip_price;
}
