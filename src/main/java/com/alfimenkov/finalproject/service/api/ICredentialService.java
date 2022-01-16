package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.*;


public interface ICredentialService {

    void createCredential(RegisterUserDto registerUserDto);
    CredentialDto readCredential(Long id);
    CredentialDto updateCredential(CredentialDto credentialDto, Long id);
    void deleteCredential(Long id);
    CredentialDto findCredentialByUsername(String username);
    CredentialDto updateCredentialPassword(Long credId, UpdatePasswordDto updatePasswordDto);
    CredentialDto updateCredentialUsername(Long credId, UpdateUsernameDto updateUsernameDto);
    CredentialDto updateCredentialRoles(Long credId, RoleDto roleName);
}
