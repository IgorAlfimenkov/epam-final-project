package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.UpdateUserDto;
import com.alfimenkov.finalproject.dto.UserDto;

import java.util.Set;

public interface IUserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UpdateUserDto updateUserDto, Long id);
    void deleteUser(Long id);
    UserDto findUser(Long id);
    Set<UserDto> findAllUsers();
}
