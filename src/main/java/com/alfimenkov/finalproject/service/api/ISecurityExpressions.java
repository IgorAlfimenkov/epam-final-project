package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.RequestRoleDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;

public interface ISecurityExpressions {

    boolean isTicketOwnedByUser(Long ticketId, Authentication authentication);
    boolean isCredentialOwnedByUser(Long credentialId, Authentication authentication);
    boolean isAdmin(@NotNull Authentication authentication);
    boolean isVip( RequestRoleDto requestRoleDto, @NotNull Authentication authentication);
}
