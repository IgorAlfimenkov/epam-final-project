package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.CredentialDto;
import com.alfimenkov.finalproject.dto.RegisterUserDto;
import com.alfimenkov.finalproject.dto.UpdatePasswordDto;
import com.alfimenkov.finalproject.dto.UpdateUsernameDto;
import com.alfimenkov.finalproject.entity.Credential;
import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ICredentialRepository;
import com.alfimenkov.finalproject.repo.IRoleRepository;
import com.alfimenkov.finalproject.service.api.ICredentialService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
@AllArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final IRoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ICredentialRepository credentialRepository;
    private final IMapper<CredentialDto, Credential> credentialMapper;


    @Override
    public void createCredential(RegisterUserDto registerUserDto) {


        Credential credential = new Credential();
        User user = new User().setName(registerUserDto.getName())
                        .setSurname(registerUserDto.getSurname())
                        .setEmail(registerUserDto.getEmail());

        credential.setUser(user.setCredential(credential))
                 .setPassword(passwordEncoder.encode(registerUserDto.getPassword()))
                .setUsername(registerUserDto.getUsername())
                .setRoles(new HashSet<Role>(){{ add(roleRepository.findRoleByName("ROLE_USER")); }});


        credentialRepository.save(credential);
    }

    @Override
    public CredentialDto readCredential(Long id) {

        Credential credential = credentialRepository.getById(id);

        return credentialMapper.toDto(credential, CredentialDto.class);
    }

    @Override
    public CredentialDto updateCredential(CredentialDto credentialDto, Long id) {

        Credential credential = credentialMapper.toEntity(credentialDto, Credential.class);
        credential.setId(id);

        return credentialMapper.toDto(credential, CredentialDto.class);
    }

    @Override
    public void deleteCredential(Long id) {

        credentialRepository.deleteById(id);
    }

   @Override
    public CredentialDto findCredentialByUsername(String username) {

        Credential credential = credentialRepository.findCredentialByUsername(username);

        return credentialMapper.toDto(credential, CredentialDto.class);
    }

    @Override
    public CredentialDto updateCredentialPassword(Long credId, UpdatePasswordDto updatePasswordDto) {
        Credential currentCredential = credentialRepository.getById(credId);
        currentCredential.setPassword(passwordEncoder.encode(updatePasswordDto.getPassword()));
        credentialRepository.save(currentCredential);

        return credentialMapper.toDto(currentCredential, CredentialDto.class);
    }

    @Override
    public CredentialDto updateCredentialUsername(Long credId, UpdateUsernameDto usernameDto) {

        Credential currentCredential = credentialRepository.getById(credId);
        currentCredential.setUsername(usernameDto.getUsername());
        credentialRepository.save(currentCredential);

        return credentialMapper.toDto(currentCredential, CredentialDto.class);
    }


}

