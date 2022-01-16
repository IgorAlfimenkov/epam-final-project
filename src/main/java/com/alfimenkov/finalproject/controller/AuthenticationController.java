package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.*;
import com.alfimenkov.finalproject.service.api.IAuthenticationService;
import com.alfimenkov.finalproject.service.api.ICredentialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final ICredentialService credentialService;
    private final IAuthenticationService authenticationService;



    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponceDto> userAuthentication(@RequestBody AuthenticationRequestDto requestDto) {

        return ResponseEntity.ok(authenticationService.login(requestDto));
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponceDto> userRegistration(@RequestBody RegisterUserDto userDto) {

        credentialService.createCredential(userDto);

        AuthenticationRequestDto requestDto =
                new AuthenticationRequestDto()
                        .setUsername(userDto.getUsername())
                        .setPassword(userDto.getPassword());

        return ResponseEntity.ok(authenticationService.login(requestDto));
    }
}
