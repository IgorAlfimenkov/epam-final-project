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
public class hotPriceDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "hot_price")
    private Double hot_price;

}
