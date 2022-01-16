package com.alfimenkov.finalproject.service.api;

import org.springframework.security.core.Authentication;

public interface ISecurityExpressions {

    boolean isTicketOwnedByUser(Long ticketId, Authentication authentication);
    boolean isCredentialOwnedByUser(Long credentialId, Authentication authentication);
}
