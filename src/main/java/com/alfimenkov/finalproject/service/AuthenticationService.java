package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.AuthenticationRequestDto;
import com.alfimenkov.finalproject.dto.AuthenticationResponceDto;
import com.alfimenkov.finalproject.entity.Credential;
import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.repo.ICredentialRepository;
import com.alfimenkov.finalproject.security.jwt.JwtTokenProvider;
import com.alfimenkov.finalproject.service.api.IAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final JwtTokenProvider tokenProvider;

    private final ICredentialRepository credentialRepository;

    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponceDto login(AuthenticationRequestDto requestDto) {

        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            Credential credential = credentialRepository.findCredentialByUsername(username);

            if (credential == null) {

                throw new UsernameNotFoundException("User with name " + requestDto.getUsername() + " not found");
            }

            String token = tokenProvider.createToken(username, new ArrayList<>(credential.getRoles()));

            return new  AuthenticationResponceDto(HttpStatus.OK.value(),username, token);
        }catch (AuthenticationException e) {

            throw new BadCredentialsException("Invalid username or password.");
        }
    }
}
