package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.UserDto;

import java.util.Set;

public interface IUserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Long id);
    void deleteUser(Long id);
    UserDto findUser(Long id);
    Set<UserDto> findAllUsers();
}
