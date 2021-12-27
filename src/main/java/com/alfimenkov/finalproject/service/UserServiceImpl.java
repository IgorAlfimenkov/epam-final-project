package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.repo.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl {

    private final IUserRepository userRepository;

    public User findUser(Long id){
        User user = userRepository.findUserById(id);
        return user;
    }

}
