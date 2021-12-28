package com.alfimenkov.finalproject.dto;

import lombok.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import java.sql.Timestamp;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketDto {

    @JsonProperty(value = "customerName")
    private String customerName;

    @JsonProperty(value = "customerSurname")
    private String customerSurname;

    @JsonProperty(value = "date")
    private Timestamp date;

    @JsonProperty(value = "tour")
    private TicketTourDto tour;

}
