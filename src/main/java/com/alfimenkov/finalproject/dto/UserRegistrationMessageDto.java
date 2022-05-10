package com.alfimenkov.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
@Accessors(chain = true)
public class UserRegistrationMessageDto implements Serializable {


    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "surname")
    private String surname;
}
