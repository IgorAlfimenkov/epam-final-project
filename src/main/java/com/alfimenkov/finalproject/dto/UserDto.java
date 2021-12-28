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
public class UserDto {

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "surname")
    private String surname;

    @JsonProperty(value = "role")
    private RoleDto role;

    @JsonProperty(value = "tickets")
    private Set<UserTicketDto> tickets;
}
