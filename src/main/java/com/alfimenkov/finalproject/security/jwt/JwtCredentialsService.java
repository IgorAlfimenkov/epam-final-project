package com.alfimenkov.finalproject.security.jwt;

import com.alfimenkov.finalproject.entity.Credential;
import com.alfimenkov.finalproject.repo.ICredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtCredentialsService  implements UserDetailsService {


    private final ICredentialRepository ICredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential userCredential = ICredentialRepository.findCredentialByUsername(username);
        return JwtUserFactory.jwtUserCreate(userCredential);
    }
}
