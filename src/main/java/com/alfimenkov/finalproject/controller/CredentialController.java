package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.CredentialDto;

import com.alfimenkov.finalproject.dto.UpdatePasswordDto;
import com.alfimenkov.finalproject.dto.UpdateUsernameDto;
import com.alfimenkov.finalproject.service.api.ICredentialService;
import com.alfimenkov.finalproject.service.api.ISecurityExpressions;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Secured("ROLE_ADMIN")
@RequestMapping("/credential")
public class CredentialController {

    private final ICredentialService credentialService;
    private final ISecurityExpressions securityExpressions;


    @Secured("ROLE_USER")
    @PutMapping("/update-password/{credId}")
    @PreAuthorize("@securityExpressions.isCredentialOwnedByUser(#credId, authentication)")
    public ResponseEntity<CredentialDto> updateCredentialPassword(@PathVariable Long credId,
                                                                  @RequestBody UpdatePasswordDto updatePassword){
        return ResponseEntity.ok(credentialService.updateCredentialPassword(credId,updatePassword));
    }

    @Secured("ROLE_USER")
    @PutMapping("/update-username/{credId}")
    @PreAuthorize("@securityExpressions.isCredentialOwnedByUser(#credId, authentication)")
    public ResponseEntity<CredentialDto> updateCredentialUsername(@PathVariable Long credId,
                                                                  @RequestBody UpdateUsernameDto updateUsername) {

        return ResponseEntity.ok(credentialService.updateCredentialUsername(credId,updateUsername));
    }

    @PutMapping("/edit/{credId}")
    public ResponseEntity<CredentialDto> updateCredential(@PathVariable Long credId,
                                                          @RequestBody CredentialDto credentialDto) {

        return ResponseEntity.ok(credentialService.updateCredential(credentialDto, credId));
    }

    @DeleteMapping ("delete/{credId}")
    public void deleteCredential(@PathVariable Long credId) {

        credentialService.deleteCredential(credId);
    }

}
