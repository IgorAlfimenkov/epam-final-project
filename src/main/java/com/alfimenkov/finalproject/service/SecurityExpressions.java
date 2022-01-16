package com.alfimenkov.finalproject.service;


import com.alfimenkov.finalproject.dto.RequestRoleDto;
import com.alfimenkov.finalproject.repo.ICredentialRepository;
import com.alfimenkov.finalproject.repo.ITicketRepository;
import com.alfimenkov.finalproject.service.api.ICredentialService;
import com.alfimenkov.finalproject.service.api.ISecurityExpressions;
import com.alfimenkov.finalproject.service.api.ITicketService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SecurityExpressions implements ISecurityExpressions {

    private final ITicketRepository ticketRepository;
    private final ICredentialRepository credentialRepository;

    public boolean isAdmin(@NotNull Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
    }


    public boolean isVip(RequestRoleDto requestRoleDto, @NotNull Authentication authentication) {
        boolean isVip = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_VIP"));
        if(isVip) requestRoleDto.setVip(true);
        return true;
    }

    @Override
    public boolean isTicketOwnedByUser(Long ticketId, Authentication authentication) {

        if(isAdmin(authentication)) return true;

        String ownerUsername = ticketRepository.getById(ticketId).getUser().
                getCredential().getUsername();

        String currentUsername = authentication.getName();

        return ownerUsername.equals(currentUsername);
    }

    @Override
    public boolean isCredentialOwnedByUser(Long credentialId, Authentication authentication) {

        if(isAdmin(authentication)) return true;

        String ownerUsername = credentialRepository.getById(credentialId).getUsername();

        String currentUsername = authentication.getName();

        return ownerUsername.equals(currentUsername);
    }
}
