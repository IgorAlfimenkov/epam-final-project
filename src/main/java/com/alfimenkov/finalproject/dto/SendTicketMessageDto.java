package com.alfimenkov.finalproject.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class SendTicketMessageDto implements Serializable {

    @JsonProperty(value = "customerName")
    private String customerName;

    @JsonProperty(value = "customerSurname")
    private String customerSurname;

    @JsonProperty(value = "date")
    private Timestamp date;

    @JsonProperty(value = "orderDate")
    private Timestamp orderDate;

    @JsonProperty(value = "tourName")
    private String tourName;

    @JsonProperty(value = "userName")
    private String userName;


}
