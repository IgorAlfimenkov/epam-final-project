package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.CredentialDto;
import com.alfimenkov.finalproject.dto.RegisterUserDto;
import com.alfimenkov.finalproject.dto.UpdatePasswordDto;
import com.alfimenkov.finalproject.dto.UpdateUsernameDto;

public interface ICredentialService {

    void createCredential(RegisterUserDto registerUserDto);
    CredentialDto readCredential(Long id);
    CredentialDto updateCredential(CredentialDto credentialDto, Long id);
    void deleteCredential(Long id);
    CredentialDto findCredentialByUsername(String username);
    CredentialDto updateCredentialPassword(Long credId, UpdatePasswordDto updatePasswordDto);
    CredentialDto updateCredentialUsername(Long credId, UpdateUsernameDto updateUsernameDto);
}
