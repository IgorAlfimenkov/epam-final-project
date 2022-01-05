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

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "surname")
    private String surname;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "login")
    private String login;

    @JsonProperty(value = "roles")
    private Set<UserRoleDto> roles;



    @JsonProperty(value = "tickets")
    private Set<UserTicketDto> tickets;
}
