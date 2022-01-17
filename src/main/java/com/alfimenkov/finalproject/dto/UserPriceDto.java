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
public class UserPriceDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "basic_price")
    private Double basic_price;
}
