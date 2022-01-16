package com.alfimenkov.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationResponceDto {

    private Integer status;

    private String username;

    private String token;

}
