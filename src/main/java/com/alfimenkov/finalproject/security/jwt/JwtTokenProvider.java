package com.alfimenkov.finalproject.security.jwt;

import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.exception.JwtAuthenticationException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {

        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken (String username, List<Role> roles) {

        Date expiration = Date.from(LocalDateTime.now()
                .plusSeconds(7500)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles.stream().map(Role::getName).collect(Collectors.toList()))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {

        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return true;
        }catch (JwtException | IllegalArgumentException e) {

            throw new JwtAuthenticationException("Token is expired or invalid", HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication getAuthentication(String token) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(getUserName(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    public String getUserName(String token) {

       return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer_")) {
            return bearerToken.substring("Bearer_".length());
        }
        return null;
    }

}
