package com.alfimenkov.finalproject.security.jwt;

import com.alfimenkov.finalproject.entity.Credential;
import com.alfimenkov.finalproject.entity.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class JwtUserFactory {

    public static User jwtUserCreate(Credential credential) {

        return new User(
                credential.getUsername(),
                credential.getPassword(),
                mapToGrantedAuthority(credential.getRoles())
        );
    }

    public static List<GrantedAuthority> mapToGrantedAuthority(Set<Role> roleSet) {
        return roleSet.stream()
                .map(role ->
                        new SimpleGrantedAuthority( role.getName()))
                .collect(Collectors.toList());

    }
}
