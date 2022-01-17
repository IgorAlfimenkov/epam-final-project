package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.UpdateUserDto;
import com.alfimenkov.finalproject.dto.UserDto;
import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.IUserRepository;
import com.alfimenkov.finalproject.service.api.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IMapper<UserDto, User> userMapper;

    public UserDto createUser(UserDto userDto) {

        User user = userMapper.toEntity(userDto, User.class);
        userRepository.save(user);

        return userMapper.toDto(user, UserDto.class);
    }

    public UserDto updateUser(UpdateUserDto updateUserDto, Long id) {

        User user = userRepository.findUserById(id);
        user.setEmail(updateUserDto.getEmail()).setSurname(updateUserDto.getSurname()).setName(updateUserDto.getName());
        userRepository.save(user);

        return userMapper.toDto(user, UserDto.class);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    public UserDto findUser(Long id){
        User user = userRepository.findUserById(id);

        return userMapper.toDto(user, UserDto.class);
    }

    public Set<UserDto> findAllUsers() {

        Set<User> users = new HashSet<>(userRepository.findAll());

        return userMapper.setToDto(users, UserDto.class);
    }


}
